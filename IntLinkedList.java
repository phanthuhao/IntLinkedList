class IntLinkedList {

    private static int counter;
    private NodeInt head;

    // Default constructor
    public IntLinkedList() {
        counter = 0;
    }

    // appends the specified element to the end of this list.
    public void add(int data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new NodeInt(data);
        }

        NodeInt intTemp = new NodeInt(data);
        NodeInt intCurrent = head;

        if (intCurrent != null) {
            while (intCurrent.getNext() != null) {
                intCurrent = intCurrent.getNext();
            }
            intCurrent.setNext(intTemp);
        }

        // increment the number of elements variable
        counter ++;
    }

    private static int getCounter() {
        return counter;
    }

    // inserts the specified element at the specified position in this list
    public void add(int data, int index) {
        NodeInt IntTemp = new NodeInt(data);
        NodeInt IntCurrent = head;
        if (IntCurrent != null) {
            for (int i = 0; i < index && IntCurrent.getNext() != null; i++) {
                IntCurrent = IntCurrent.getNext();
            }
        }
        IntTemp.setNext(IntCurrent.getNext());

        // now set this node's next-node reference to the new node
        IntCurrent.setNext(IntTemp);

        // increment the number of elements variable
        counter ++;
    }

    //if object have data < value, remove object
    public void removeGreatValue(int value){
        NodeInt intCurrent = head;
        int no = 0;
        if (intCurrent != null) {
            while (intCurrent.getNext() != null) {
                if(intCurrent.getData() < value){
                    //head < value
                    if(no == 0){
                        head = intCurrent.getNext();
                        counter --;
                    }
                    else {
                        remove(no);
                    }
                }
                else {
                    no ++;
                }
                intCurrent = intCurrent.getNext();
            }
            //check last object
            if(intCurrent.getData() < value){
                removeLast();
            }
        }
    }

    //remove last object
    public boolean removeLast(){
        return remove(size() -1);
    }

    // removes the element at the specified position in this list.
    public boolean remove(int index) {

        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;

        NodeInt crunchifyCurrent = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (crunchifyCurrent.getNext() == null)
                    return false;

                crunchifyCurrent = crunchifyCurrent.getNext();
            }
            crunchifyCurrent.setNext(crunchifyCurrent.getNext().getNext());

            // decrement the number of elements variable
            counter --;
            return true;

        }
        return false;
    }

    // returns the number of elements in this list.
    public int size() {
        return getCounter();
    }

    private class NodeInt {
        NodeInt next;
        int data;
        public NodeInt(int dataValue) {
            next = null;
            data = dataValue;
        }

        @SuppressWarnings("unused")
        public NodeInt(int dataValue, NodeInt nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public int getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(int dataValue) {
            data = dataValue;
        }

        public NodeInt getNext() {
            return next;
        }

        public void setNext(NodeInt nextValue) {
            next = nextValue;
        }

    }
}