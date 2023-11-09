package disciplina_atal.data_structures.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class MjxConjuntoInteiros {
	/** A referência para o primeiro nó da lista. */
    private ConjutoInteirosNode head;
    
    /** A referência para o último nó da lista. */
    private ConjutoInteirosNode tail;

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
    public ConjutoInteirosNode getHead() {
        return this.head;
    }
    
    /**
     * Retorna o ultimo nó da lista.
     *
     * @return ultimo nó.
     */
    public ConjutoInteirosNode getTail() {
        return this.tail;
    }

    /**
     * Adiciona um novo nó à lista com o valor inteiro fornecidos.
     *
     * @param value O valor inteiro a ser associado ao novo nó.
     */
    public void add(int value) {
    	ConjutoInteirosNode newNode = new ConjutoInteirosNode(value);

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
     * Remove o nó da lista com o valor inteiro fornecido.
     *
     * @param name O valor inteiro do nó a ser removido.
     */
    public void remove(int value) {
    	ConjutoInteirosNode current = head;

        while (current != null) {
            if (current.getValue() == value) {
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
     * Realiza a união deste conjunto com outro conjunto, inserindo apenas valores diferentes.
     *
     * @param otherSet O outro conjunto a ser unido a este conjunto.
     * @return Um novo conjunto contendo a união dos elementos deste conjunto e do outro conjunto,
     *         inserindo apenas valores diferentes.
     */
    public MjxConjuntoInteiros union(MjxConjuntoInteiros otherSet) {
        MjxConjuntoInteiros result = new MjxConjuntoInteiros();

        // Adiciona todos os elementos deste conjunto ao resultado
        ConjutoInteirosNode currentThis = this.getHead();
        while (currentThis != null) {
            result.addIfNotPresent(currentThis.getValue());
            currentThis = currentThis.getNext();
        }

        // Adiciona todos os elementos do outro conjunto ao resultado
        ConjutoInteirosNode currentOther = otherSet.getHead();
        while (currentOther != null) {
            result.addIfNotPresent(currentOther.getValue());
            currentOther = currentOther.getNext();
        }

        return result;
    }

    /**
     * Adiciona um valor ao conjunto apenas se ele não estiver presente.
     *
     * @param value O valor a ser adicionado ao conjunto.
     */
    public void addIfNotPresent(int value) {
        if (!contains(value)) {
            add(value);
        }
    }


    /**
     * Realiza a interseção deste conjunto com outro conjunto fornecido como parâmetro.
     *
     * @param otherSet O conjunto a ser intersecionado com este conjunto.
     * @return Um novo conjunto representando a interseção dos conjuntos.
     */
    public MjxConjuntoInteiros intersection(MjxConjuntoInteiros otherSet) {
        MjxConjuntoInteiros result = new MjxConjuntoInteiros();
        Set<Integer> uniqueValues = new HashSet<>();

        // Adiciona os valores únicos deste conjunto ao conjunto temporário
        ConjutoInteirosNode currentThis = this.head;
        while (currentThis != null) {
            uniqueValues.add(currentThis.getValue());
            currentThis = currentThis.getNext();
        }

        // Adiciona os valores que também estão no outro conjunto ao resultado
        ConjutoInteirosNode currentOther = otherSet.head;
        while (currentOther != null) {
            if (uniqueValues.contains(currentOther.getValue())) {
                result.add(currentOther.getValue());
            }
            currentOther = currentOther.getNext();
        }

        return result;
    }

    /**
     * Realiza a diferença deste conjunto com outro conjunto fornecido como parâmetro.
     *
     * @param otherSet O conjunto a ser subtraído deste conjunto.
     * @return Um novo conjunto representando a diferença dos conjuntos.
     */
    public MjxConjuntoInteiros difference(MjxConjuntoInteiros otherSet) {
        MjxConjuntoInteiros result = new MjxConjuntoInteiros();
        Set<Integer> valuesToRemove = new HashSet<>();

        // Adiciona os valores únicos deste conjunto ao conjunto resultado
        ConjutoInteirosNode currentThis = this.head;
        while (currentThis != null) {
            result.add(currentThis.getValue());
            currentThis = currentThis.getNext();
        }

        // Adiciona os valores a serem removidos ao conjunto temporário
        ConjutoInteirosNode currentOther = otherSet.head;
        while (currentOther != null) {
            valuesToRemove.add(currentOther.getValue());
            currentOther = currentOther.getNext();
        }

        // Remove os valores presentes na interseção dos conjuntos
        ConjutoInteirosNode currentResult = result.head;
        while (currentResult != null) {
            if (valuesToRemove.contains(currentResult.getValue())) {
                result.remove(currentResult.getValue());
            }
            currentResult = currentResult.getNext();
        }

        return result;
    }

    /**
     * Verifica se este conjunto é subconjunto de outro conjunto fornecido como parâmetro.
     *
     * @param otherSet O conjunto a ser verificado se contém este conjunto.
     * @return true se este conjunto for subconjunto de otherSet, false caso contrário.
     */
    public boolean pertinence(MjxConjuntoInteiros otherSet) {
        ConjutoInteirosNode currentThis = this.head;

        // Verifica se todos os elementos deste conjunto estão presentes no outro conjunto
        while (currentThis != null) {
            if (!otherSet.contains(currentThis.getValue())) {
                return false;
            }
            currentThis = currentThis.getNext();
        }

        return true;
    }


    /**
     * Verifica se um valor inteiro está presente neste conjunto.
     *
     * @param value O valor inteiro a ser verificado.
     * @return true se o valor estiver presente, false caso contrário.
     */
    private boolean contains(int value) {
        ConjutoInteirosNode current = this.head;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Imprime todos os elementos da lista.
     */
    public void printAll() {
    	ConjutoInteirosNode current = head;

        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }

}
