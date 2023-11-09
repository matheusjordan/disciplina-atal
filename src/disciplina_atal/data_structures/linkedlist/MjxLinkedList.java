package disciplina_atal.data_structures.linkedlist;

/**
 * Representa uma lista encadeada dupla.
 * A lista mantém uma referência para a cabeça (head) e a cauda (tail), e oferece métodos
 * para realizar operações comuns em uma lista, como adicionar, remover, imprimir, copiar,
 * unir e intercalar com outra lista.
 */
public class MjxLinkedList {
    
    /** A referência para o primeiro nó da lista. */
    private LinkedListNode head;
    
    /** A referência para o último nó da lista. */
    private LinkedListNode tail;

    /**
     * Verifica se a lista está vazia.
     *
     * @return true se a lista estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return this.head == null;
    }
    
    /**
     * Retorna o primeiro nó da lista.
     *
     * @return primeiro nó.
     */
    public LinkedListNode getHead() {
        return this.head;
    }
    
    /**
     * Retorna o ultimo nó da lista.
     *
     * @return ultimo nó.
     */
    public LinkedListNode getTail() {
        return this.tail;
    }

    /**
     * Adiciona um novo nó à lista com o nome e chave fornecidos.
     *
     * @param name O nome a ser associado ao novo nó.
     * @param key  A chave a ser associada ao novo nó.
     */
    public void add(String name, int key) {
        LinkedListNode newNode = new LinkedListNode(name, key);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    /**
     * Remove o nó da lista com o nome e chave fornecidos.
     *
     * @param name O nome do nó a ser removido.
     * @param key  A chave do nó a ser removido.
     */
    public void remove(String name, int key) {
        LinkedListNode current = head;

        while (current != null) {
            if (current.getName().equals(name) && current.getKey() == key) {
                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }

                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                } else {
                    tail = current.getPrevious();
                }

                current.setNext(null);
                current.setPrevious(null);

                break;
            }

            current = current.getNext();
        }
    }

    /**
     * Imprime todos os elementos da lista.
     */
    public void printAll() {
        LinkedListNode current = head;

        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }

    /**
     * Cria uma cópia da lista atual.
     *
     * @return Uma nova lista contendo cópias dos elementos da lista atual.
     */
    public MjxLinkedList getCopy() {
        MjxLinkedList list = new MjxLinkedList();

        LinkedListNode current = head;

        while (current != null) {
            list.add(current.getName(), current.getKey());
            current = current.getNext();
        }

        return list;
    }

    /**
     * Junta a lista atual com outra lista fornecida como parâmetro.
     *
     * @param otherList A lista a ser unida à lista atual.
     */
    public void joinList(MjxLinkedList otherList) {
        if (otherList != null && !otherList.isEmpty()) {
            if (this.isEmpty()) {
                this.head = otherList.head;
                this.tail = otherList.tail;
            } else {
                this.tail.setNext(otherList.head);
                otherList.head.setPrevious(this.tail);
                this.tail = otherList.tail;
            }
        }
    }

    /**
     * Entrelaça a lista atual com outra lista fornecida como parâmetro.
     *
     * @param otherList A lista a ser entrelaçada com a lista atual.
     */
    public void interleaveList(MjxLinkedList otherList) {
        if (otherList != null && !otherList.isEmpty()) {
            LinkedListNode currentThis = head;
            LinkedListNode currentOther = otherList.head;

            while (currentThis != null && currentOther != null) {
                LinkedListNode nextThis = currentThis.getNext();
                LinkedListNode nextOther = currentOther.getNext();

                currentThis.setNext(currentOther);
                currentOther.setPrevious(currentThis);

                if (nextThis != null) {
                    currentOther.setNext(nextThis);
                    nextThis.setPrevious(currentOther);
                } else {
                    tail = currentOther;
                }

                currentThis = nextThis;
                currentOther = nextOther;
            }

            if (currentOther != null) {
                tail = otherList.tail;
            }
        }
    }
}


