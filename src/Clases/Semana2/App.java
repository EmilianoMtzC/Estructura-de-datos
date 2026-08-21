package Clases.Semana2;

public class App {
    void main() {
        Stack pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        IO.println(pila.peek()); // 4
        pila.pop(); // 3,2,1
        IO.println(pila.peek()); //3
        pila.showStack(); //3,2,1
    }
}
