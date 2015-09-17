package golub.morsecode;

public enum MorseCodeLanguage {

	A(".-"), B("-..."), C("-.-."), D("-.."), E("."), F("..-."), G("--."), 
	H("...."), I(".."), J(".---"), K("-.-"), L(".-.."), M("--"), N("-."), 
	O("---"), P(".--."), Q("--.-"), R(".-."), S("..."), T("-"), U("..-"), 
	V("...-"), W(".--"), X("-..-"), Y("-.--"), Z("--..");

	private String morseCode;

	private MorseCodeLanguage(String morse) {
		this.morseCode = morse;
	}	
   public String getMorseCode(){
	   return this.morseCode;
   }
   public String toString(){
	   return this.morseCode;
   }
  
   

	
}
