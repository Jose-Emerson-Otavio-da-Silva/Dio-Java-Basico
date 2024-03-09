package one.digitalinovation;

public class No {

    private int dado;
    private No refNo = null;

    /**
     * Construtor
     * 
     * @param dado
     */
    public No(int dado) {
        this.dado = dado;
    }

    /**
     * Construtor vazio
     */
    public No() {

    }

    /**
     * Get e Setters
     */
    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getRefNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "No [dado=" + dado + "]";
    }
}
