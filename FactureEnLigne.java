package projet_java;

import java.util.Date;
import java.util.Objects;

public class FactureEnLigne extends Facture implements Comparable<FactureEnLigne>, Cloneable {
    private String lienFactureEnLigne;

    public FactureEnLigne() {
        super();
        this.lienFactureEnLigne = "";
    }

    public FactureEnLigne(int numFac, Date dateEmi, double mtTotal, boolean estPayee, String lienFactureEnLigne) {
        super(numFac, dateEmi, mtTotal, estPayee);
        this.lienFactureEnLigne = lienFactureEnLigne;
    }

    @Override
    public String toString() {
        return super.toString() + " FactureEnLigne [lienFactureEnLigne=" + lienFactureEnLigne + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        FactureEnLigne other = (FactureEnLigne) obj;
        return Objects.equals(lienFactureEnLigne, other.lienFactureEnLigne);
    }

    @Override
    public FactureEnLigne clone() {
        return new FactureEnLigne(this.getNumeroFacture(), this.getDateEmission(), this.getMontantTotal(),
                this.isEstPayee(), this.lienFactureEnLigne);
    }

    @Override
    public int compareTo(FactureEnLigne autreFacture) {
       
        return Integer.compare(this.getNumeroFacture(), autreFacture.getNumeroFacture());
    }
}
