//ACESTA ESTE MODELUL

package entities;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Arrays;
import java.util.Objects;

public class Comanda extends Produs{

    @OneToMany
    Produs arrayProduse[] = new Produs[10];

    @OneToOne
    User user;



    @Override
    public String toString() {
        return "Comanda{" +
                "arrayProduse=" + Arrays.toString(arrayProduse) +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comanda)) return false;
        Comanda comanda = (Comanda) o;
        return Arrays.equals(getArrayProduse(), comanda.getArrayProduse()) &&
                getUser().equals(comanda.getUser());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getUser());
        result = 31 * result + Arrays.hashCode(getArrayProduse());
        return result;
    }

    public Produs[] getArrayProduse() {
        return arrayProduse;
    }

    public void setArrayProduse(Produs[] arrayProduse) {
        this.arrayProduse = arrayProduse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
