package Fil_Rouge;

public interface InterfaceDao {
	public void ajouterproduit (final int id, final int noproduit, final String nom, final String produit1, final String produit2, final String produit3, final String produit4, final String produit5, final float prix);
	public void deletesandwich ( final int id);
	public  void getsandwich(final int id);
	public  void getsandwichs();
	public void dateAchat (final int id);
}
