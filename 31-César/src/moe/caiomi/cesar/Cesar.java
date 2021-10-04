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
			int temp;
			if(Character.isLetter(c)){
				if(Character.isUpperCase(c)){
					int ascii = (int) c;
					System.out.println("lettre="+c);
					System.out.println("ascii="+ascii);
					ascii += key;
					if (ascii > 90) {
						temp = ascii - 91;
						ascii = 65 + temp;
					}
					c = (char) ascii;
					System.out.println("lettreCode="+c);
					System.out.println("asciiCode="+ascii);
				}else{
					int ascii = (int) c;
					System.out.println("lettre="+c);
					System.out.println("ascii="+ascii);
					ascii += key;
					if (ascii > 122) {
						temp = ascii - 123;
						ascii = 97 + temp;
					}
					c = (char) ascii;
					System.out.println("lettreCode="+c);
					System.out.println("asciiCode="+ascii);
				}
			}
			this.messageDecode += c;
		}
	}
	
	public void Decoder_Cesar(String motAdecoder){
		this.messageCode = motAdecoder;
		for(int i = 0; i < this.messageCode.length(); i++){
			char c = this.messageCode.charAt(i);
			int temp;
			if(Character.isLetter(c)){
				if(Character.isUpperCase(c)){
					int ascii = (int) c;
					System.out.println("lettre="+c);
					System.out.println("ascii="+ascii);
					ascii -= key;
					if (ascii < 64) {
						temp = 64 - ascii;
						ascii = 90 + temp;
					}
					c = (char) ascii;
					System.out.println("lettreCode="+c);
					System.out.println("asciiCode="+ascii);
					System.out.println();
				}else{
					//LOWERCASE
					int ascii = (int) c;
					System.out.println("lettre="+c);
					System.out.println("ascii="+ascii);
					ascii -= key;
					if (ascii < 96) {
						temp = 96 - ascii;
						ascii = 122 - temp;
					}
					c = (char) ascii;
					System.out.println("lettreCode="+c);
					System.out.println("asciiCode="+ascii);
					System.out.println();
				}
			}
			this.messageDecode += c;
		}
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
