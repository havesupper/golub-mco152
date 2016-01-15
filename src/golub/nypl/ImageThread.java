package golub.nypl;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageThread extends Thread{

	private SearchOnlinePic searchOnlinePic;
	private SearchObject searchObject;
	private NYPLAPI nyplApi;
	private Response response;
	private Capture[] capture;
	private ImageLinks imageLinks;
	private ImageLinks[] links;
	private String[] pictureUrl;
	private Image image;
	private ImageIcon imageIcon;
	private JLabel picture;
	private String url;
	private int choice;
	
	
	public ImageThread(JLabel picture, String url, int choice){
		this.picture = picture;
		this.url = url;
		this.choice = choice;
	}
	public void run(){
		try{
			searchOnlinePic = new SearchOnlinePic(url);
			searchObject = searchOnlinePic.getSearchObject();
			nyplApi = searchObject.getNyplAPI();
			response = nyplApi.getResponse();
			capture = response.getCapture();
			
			imageLinks = capture[0].getImageLinks();
			
			String[] urls = imageLinks.getImageLinks();
			String picUrl = urls[4];
			
			
			URL url = new URL(picUrl);
			image = ImageIO.read(url);
			imageIcon = new ImageIcon(image);
			picture.setIcon(imageIcon);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public JLabel getPicture() {
		return picture;
	}
	
}
