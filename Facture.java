package projet_java;
import java.util.Date;
import java.util.Objects;

public class Facture {
	
	 private int numeroFacture;    
	 private Date dateEmission;     
	 private double montantTotal;    
	 private boolean estPayee; 

	public Facture() {
	        this.numeroFacture = 0;
	        this.dateEmission = new Date();
	        this.montantTotal = 0.0;
	        this.estPayee = false;
	    }

   public Facture(int numFac, Date dateEmi, double mtTotal, boolean estPayee) {
	        this.numeroFacture = numFac;
	        this.dateEmission = dateEmi;
	        this.montantTotal = mtTotal;
	        this.estPayee = estPayee;
	    }
   @Override
  	public String toString() {
  		return "Facture [numeroFacture=" + numeroFacture + ", dateEmission=" + dateEmission + ", montantTotal="
  				+ montantTotal + ", estPayee=" + estPayee + "]";
  	}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Facture other = (Facture) obj;
	return Objects.equals(dateEmission, other.dateEmission) && estPayee == other.estPayee
			&& Double.doubleToLongBits(montantTotal) == Double.doubleToLongBits(other.montantTotal)
			&& numeroFacture == other.numeroFacture;
}
   
}
