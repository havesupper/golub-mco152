package golub.nypl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;

public class NyplGui extends JFrame {

	private JList<SearchResult> list;
	private TextField searchBox;
	private JButton buttonSearch;
	private JLabel picture;
	private String searchWord;
	private String url;

	public NyplGui() {
		setTitle("NYPL Search");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		Panel topBar = new Panel();
		topBar.setLayout(new BorderLayout());

		searchBox = new TextField();
		topBar.add(searchBox, BorderLayout.CENTER);

		buttonSearch = new JButton("Search");
		topBar.add(buttonSearch, BorderLayout.EAST);

		container.add(topBar, BorderLayout.NORTH);

		Panel leftList = new Panel();
		leftList.setLayout(new BorderLayout());

		list = new JList<SearchResult>();
		picture = new JLabel();
		
		searchBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchWord = searchBox.getText().toString();
				SearchThread thread = new SearchThread(list, searchWord);
				thread.start();

				leftList.add(list, BorderLayout.CENTER);
				container.add(leftList, BorderLayout.WEST);

				list.setCellRenderer(new DefaultListCellRenderer() {
					@Override
					public Component getListCellRendererComponent(JList<?> list, Object value, int index,
							boolean isSelected, boolean cellHasFocus) {
						Component renderer = super.getListCellRendererComponent(list, value, index, isSelected,
								cellHasFocus);
						if (renderer instanceof JLabel && value instanceof SearchResult) {
							if (((SearchResult) value).getTitle().length()>30){
								String temp = ((SearchResult)value).getTitle();
								String letters = temp.substring(0, Math.min(temp.length(), 30));
								((JLabel) renderer).setText(letters);
								
							}
							else{
							((JLabel) renderer).setText(((SearchResult) value).getTitle());
							}
						}
						return renderer;
					}

				});

				container.add(picture, BorderLayout.CENTER);
			}

		});
		buttonSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchWord = searchBox.getText().toString();
				SearchThread thread = new SearchThread(list, searchWord);
				thread.start();

				leftList.add(list, BorderLayout.CENTER);
				container.add(leftList, BorderLayout.WEST);

				list.setCellRenderer(new DefaultListCellRenderer() {
					@Override
					public Component getListCellRendererComponent(JList<?> list, Object value, int index,
							boolean isSelected, boolean cellHasFocus) {
						Component renderer = super.getListCellRendererComponent(list, value, index, isSelected,
								cellHasFocus);
						if (renderer instanceof JLabel && value instanceof SearchResult) {
							if (((SearchResult) value).getTitle().length()>30){
								String temp = ((SearchResult)value).getTitle();
								String letters = temp.substring(0, Math.min(temp.length(), 30));
								((JLabel) renderer).setText(letters);
								
							}
							else{
							((JLabel) renderer).setText(((SearchResult) value).getTitle());
							}
						}
						return renderer;
					}

				});

				container.add(picture, BorderLayout.CENTER);
			}

		});
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList list = (JList) event.getSource();
				if (event.getClickCount() == 1) {
					int index = list.locationToIndex(event.getPoint());
					ListModel result = list.getModel();
					SearchResult item = (SearchResult) result.getElementAt(index);
					url = item.getApiItemURL();
					ImageThread Ithread = new ImageThread(picture, url, index);
					Ithread.start();
				}
			}
		});

	}

	public static void main(String[] args) {
		NyplGui gui = new NyplGui();
		gui.setVisible(true);
	}

}
