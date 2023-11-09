package disciplina_atal.data_structures.linkedlist;

/**
 * Representa um nó em uma lista duplamente encadeada.
 * Cada nó contém um nome, uma chave e referências para os nós seguinte e anterior.
 */
public class LinkedListNode {
    
    /** O nome associado a este nó. */
    private String name;
    
    /** A chave associada a este nó. */
    private int key;
    
    /** Referência para o próximo nó na lista. */
    private LinkedListNode next;
    
    /** Referência para o nó anterior na lista. */
    private LinkedListNode previous;

    /**
     * Constrói um novo LinkedListNode com o nome e chave fornecidos.
     *
     * @param name O nome associado ao nó.
     * @param key  A chave associada ao nó.
     */
    public LinkedListNode(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**
     * Obtém o nome associado a este nó.
     *
     * @return O nome do nó.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome associado a este nó.
     *
     * @param name O novo nome para o nó.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a chave associada a este nó.
     *
     * @return A chave do nó.
     */
    public int getKey() {
        return key;
    }

    /**
     * Define a chave associada a este nó.
     *
     * @param key A nova chave para o nó.
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Obtém o próximo nó na lista.
     *
     * @return O próximo nó na lista.
     */
    public LinkedListNode getNext() {
        return next;
    }

    /**
     * Define o próximo nó na lista.
     *
     * @param next O próximo nó na lista.
     */
    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    /**
     * Obtém o nó anterior na lista.
     *
     * @return O nó anterior na lista.
     */
    public LinkedListNode getPrevious() {
        return previous;
    }

    /**
     * Define o nó anterior na lista.
     *
     * @param previous O nó anterior na lista.
     */
    public void setPrevious(LinkedListNode previous) {
        this.previous = previous;
    }

    /**
     * Retorna uma representação em string do nó.
     *
     * @return Uma representação em string do nó.
     */
    @Override
    public String toString() {
        return name + "(" + key + ")";
    }
}


