package golub.nypl;

import java.io.IOException;

import javax.swing.JList;

public class SearchThread extends Thread{
	
	private SearchOnline searchOnline;
	private SearchObject searchObject;
	private NYPLAPI nyplapi;
	private JList<SearchResult> list;
	private Response response;
	private SearchResult[] results;
	private String searchWord;
	
	public SearchThread(JList list, String searchWord){
		this.list = list;
		this.searchWord = searchWord;
	}
	
	public void run(){
			
		try{
		
		searchOnline = new SearchOnline(searchWord);
		searchObject = searchOnline.getSearchObject();
		nyplapi = searchObject.getNyplAPI();
		response = nyplapi.getResponse();
		results = response.getResult();
		list.setListData(results);
		/*title = new String[results.length];
		for (int i = 0; i < results.length; i++){
			title[i] = results[i].getTitle();
			if (title[i].length() > 30){
			String temp = title[i];
			String letters = temp.substring(0, Math.min(temp.length(), 30));
			title[i] = letters;
		}
		}
		
		list.setListData(title);*/
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public SearchResult[] getTitle() {
		return results;
	}

}
