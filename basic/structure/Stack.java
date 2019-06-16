package basic.structure;

public class Stack {
    private Integer[] el;
    private Integer length;

    public Stack(Integer length) {
        el = new Integer[length];
        this.length = -1;
    }

    public Stack() {
        el = new Integer[10];
        this.length = -1;
    }

    public boolean empty() {
        return length == -1;
    }

    public void push(Integer element) {
        if (length < el.length) {
            el[++length] = element;
        }
    }

    public Integer pop() {
        if (length > -1) {
            Integer temp = el[length];
            el[length--] = null;
            return temp;
        }
        return null;
    }

    public Integer peek() {
        if (length > -1) {
            return el[length];
        }
        return null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (Integer i = 0; i < 10; i++) {
            stack.push(i);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}