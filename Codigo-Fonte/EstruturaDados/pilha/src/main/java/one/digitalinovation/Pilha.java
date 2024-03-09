package one.digitalinovation;

public class Pilha {
    private No refNoEntradaPilha;

    /**
     * Construtor
     */
    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    /**
     * Método de empilhar, adiciona novo valor no topo da pilha
     * 
     * @param novoNo
     */
    public void push(No novoNo) {
        No refAuxiliar = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    /**
     * Exclui o item do topo da pilha
     * 
     * @return item removido
     */
    public No pop() {
        if (!this.isEmpty()) {
            No noPoped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            return noPoped;
        }
        return null;
    }

    /**
     * @return refNoEntradaPilha que é a referencia do top da pilha
     */
    public No top() {
        return refNoEntradaPilha;
    }

    /**
     * @return se pilha está vazia ou não
     */
    public boolean isEmpty() {
        return refNoEntradaPilha == null ? true : false;
    }

    @Override
    public String toString() {

        String stringRetorno = "---------------------\n";
        stringRetorno += "        Pilha\n";
        stringRetorno += "---------------------\n";

        No noAuxiliar = refNoEntradaPilha;

        while (true) {
            if (noAuxiliar != null) {
                stringRetorno += "[No{dado=" + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            } else {
                break;
            }
        }
        stringRetorno += "====================\n";
        return stringRetorno;
    }

}
