package db;

public class match {
private	Integer idmatch;
private	String statue;
private  Integer scoreequipeone;
private  Integer scoreequipetwo;
private String nameequipetow;
private String nameequipeone;
	public match(Integer idmatch,String statue,Integer scoreequipeone,Integer scoreequipetwo,String nameequipeone,String nameequipetow){
		setIdmatch(idmatch);
		setStatue(statue);
		setScoreequipeone(scoreequipeone);
		setScoreequipetwo(scoreequipetwo);
		setNameequipeone(nameequipeone);
		setNameequipetow(nameequipetow);
		
	}
	public Integer getIdmatch() {
		return idmatch;
	}
	public void setIdmatch(Integer idmatch) {
		this.idmatch = idmatch;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	public Integer getScoreequipeone() {
		return scoreequipeone;
	}
	public void setScoreequipeone(Integer scoreequipeone) {
		this.scoreequipeone = scoreequipeone;
	}
	public Integer getScoreequipetwo() {
		return scoreequipetwo;
	}
	public void setScoreequipetwo(Integer scoreequipetwo) {
		this.scoreequipetwo = scoreequipetwo;
	}
	public String getNameequipetow() {
		return nameequipetow;
	}
	public void setNameequipetow(String nameequipetwo) {
		this.nameequipetow = nameequipetwo;
	}
	public String getNameequipeone() {
		return nameequipeone;
	}
	public void setNameequipeone(String nameequipeone) {
		this.nameequipeone = nameequipeone;
	}
	
}
