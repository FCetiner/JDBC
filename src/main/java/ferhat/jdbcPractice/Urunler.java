package ferhat.jdbcPractice;

public class Urunler {

	private int  ted_vergino; 
	private int urun_id; 
	private String urun_isim;
	private String musteri_isim;
	public Urunler(int ted_vergino, int urun_id, String urun_isim, String musteri_isim) {
		super();
		this.ted_vergino = ted_vergino;
		this.urun_id = urun_id;
		this.urun_isim = urun_isim;
		this.musteri_isim = musteri_isim;
	}
	public int getTed_vergino() {
		return ted_vergino;
	}
	public void setTed_vergino(int ted_vergino) {
		this.ted_vergino = ted_vergino;
	}
	public int getUrun_id() {
		return urun_id;
	}
	public void setUrun_id(int urun_id) {
		this.urun_id = urun_id;
	}
	public String getUrun_isim() {
		return urun_isim;
	}
	public void setUrun_isim(String urun_isim) {
		this.urun_isim = urun_isim;
	}
	public String getMusteri_isim() {
		return musteri_isim;
	}
	public void setMusteri_isim(String musteri_isim) {
		this.musteri_isim = musteri_isim;
	}
	@Override
	public String toString() {
		return "Urunler [ted_vergino=" + ted_vergino + ", urun_id=" + urun_id + ", urun_isim=" + urun_isim
				+ ", musteri_isim=" + musteri_isim + "]";
	}
}
