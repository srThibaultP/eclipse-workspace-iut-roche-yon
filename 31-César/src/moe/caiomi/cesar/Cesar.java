package moe.caiomi.cesar;

public class Cesar {
	private int key = 3;
	private String messageCode = "";
	private String messageDecode = "";
	
	public Cesar(int pKey) {
		this.key = pKey;
	}

	public void Coder_Cesar(String motAcoder){
		this.messageCode = motAcoder;
		for(int i = 0; i < this.messageCode.length(); i++){
			char c = this.messageCode.charAt(i);
			if(Character.isLetter(c)){
				if(Character.isUpperCase(c)){
					c = (char)(((c - 'A' + this.key) % 26) + 'A');
				}else{
					c = (char)(((c - 'a' + this.key) % 26) + 'a');
				}
			}
			this.messageDecode += c;
			//System.out.println(this.messageDecode);
		}
	}
	
	public void Decoder_Cesar(String motAdecoder){
		this.messageDecode = motAdecoder;
		for(int i = 0; i < this.messageDecode.length(); i++){
			char c = this.messageDecode.charAt(i);
			if(Character.isLetter(c)){
				if(Character.isUpperCase(c)){
					c = (char)(((c - 'A' - this.key) % 26) + 'A');
				}else{
					c = (char)(((c - 'a' - this.key) % 26) + 'a');
				}
			}
			this.messageCode += c;
		}
		//System.out.println(this.messageCode);
	}


	public String getMessageDecode() {
		return messageDecode;
	}
	public void setMessageDecode(String pMessage) {
		this.messageDecode = pMessage;
	}

	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String pMessage) {
		this.messageCode = pMessage;
	}

	public int getKey() {
		return key;
	}
	public void setKey(int pKey) {
		this.key = pKey;
	}
}
