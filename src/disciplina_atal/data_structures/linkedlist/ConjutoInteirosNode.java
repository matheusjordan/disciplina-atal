package disciplina_atal.data_structures.linkedlist;

/**
 * Representa um nó em uma lista duplamente encadeada.
 * Cada nó contém um inteiro e referências para os nós seguinte e anterior.
 */
public class ConjutoInteirosNode {
    
    /** O valor associado a este nó. */
    private int value;
    
    /** Referência para o próximo nó na lista. */
    private ConjutoInteirosNode next;
    
    /** Referência para o nó anterior na lista. */
    private ConjutoInteirosNode previous;

    /**
     * Constrói um novo ConjutoInteirosNode com o valor fornecido.
     *
     * @param value O valor associado ao nó.
     */
    public ConjutoInteirosNode(int value) {
        this.value = value;
    }

    /**
     * Obtém o valor associado a este nó.
     *
     * @return O valor do nó.
     */
    public int getValue() {
        return value;
    }

    /**
     * Define o valor associado a este nó.
     *
     * @param value O valor inteiro para o nó.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Obtém o próximo nó na lista.
     *
     * @return O próximo nó na lista.
     */
    public ConjutoInteirosNode getNext() {
        return next;
    }

    /**
     * Define o próximo nó na lista.
     *
     * @param next O próximo nó na lista.
     */
    public void setNext(ConjutoInteirosNode next) {
        this.next = next;
    }

    /**
     * Obtém o nó anterior na lista.
     *
     * @return O nó anterior na lista.
     */
    public ConjutoInteirosNode getPrevious() {
        return previous;
    }

    /**
     * Define o nó anterior na lista.
     *
     * @param previous O nó anterior na lista.
     */
    public void setPrevious(ConjutoInteirosNode previous) {
        this.previous = previous;
    }
    
    /**
     * Verifica se o conjunto contém um determinado valor.
     *
     * @param value O valor a ser verificado.
     * @return true se o valor estiver presente no conjunto, false caso contrário.
     */
    public boolean contains(int value) {
        return getValue() == value || (getNext() != null && getNext().contains(value));
    }

    /**
     * Retorna uma representação em string do nó.
     *
     * @return Uma representação em string do nó.
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }
}


