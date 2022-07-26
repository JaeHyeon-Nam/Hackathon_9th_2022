class AnimalDTO 
{
	AnimalDTO(){};
	private String petNum; // 동물 번호
	private String petName; //동물 이름
	private String petSp; // 종 (강아지, 고양이)
	private String petKind; // 품종(ex:푸들)
	private String petSex; // 암컷 수컷
	private String petAge; // 동물 나이
	private String petWeight;//몸무게
	private String petVideo;
	/*통상적으로 10kg 이하인 경우에는 소형견이라고 보고
		10kg이 초과 25kg 이하인 경우 중형견이라고 봅니다.
		25kg 이상이라면 대형견이라고 구분할 수 있습니다.
	*/
	private String hospiAdd; // 동물명원 주소
	private String hospiName; // 동물병원 이름

	public void setPetNum(String _petNum){
		petNum = _petNum;
	}
	public void setPetName(String _petName){
		petName = _petName;
	}
	public void setPetSp(String _petSp){
		petSp = _petSp;
	}
	public void setPetKind(String _petKind){
		petKind = _petKind;
	}
	public void setPetSex(String _petSex){
		petSex = _petSex;
	}
	public void setPetAge(String _petAge){
		petAge = _petAge;
	}
	public void setPetWeight(String _petWeight){
		petWeight = _petWeight;
	}
	public void setPetVideo(String _petVideo){
		petVideo = _petVideo;
	}
	public void setHospiAdd(String _hospiAdd){
		hospiAdd = _hospiAdd;
	}
	public void setHospiName(String _hospiName){
		hospiName = _hospiName;
	}

	public String getPetNum(){
		return petNum;
	}
	public String getPetName(){
		return petName;
	}
	public String getPetSp(){
		return petSp;
	}
	public String getPetKind(){
		return petKind;
	}
	public String getPetSex(){
		return petSex;
	}
	public String getPetAge(){
		return petAge;
	}
	public String getPetWeight(){
		return petWeight;
	}
	public String getPetVideo(){
		return petVideo;
	}
	public String getHospiAdd(){
		return hospiAdd;
	}
	public String getHospiName(){
		return hospiName;
	}
}
