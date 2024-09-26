package listas_circulares;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Martin Cantillo
 */
public class Listas_circulares {

    Scanner entrada = new Scanner(System.in);

    public class nodo {

        int dato;
        nodo sig;

    }
    nodo cab, q, p, aux, t, m, cab2, ultimo;

    public Listas_circulares() {
        this.cab = null;
        this.q = null;
        this.p = null;
        this.aux = null;
        this.t = null;
        this.m = null;
        this.cab2 = null;
        this.ultimo = null;
    }

    public boolean listavacia() {
        if (cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public nodo insertar_inicio(int info) {
        nodo n = new nodo();
        n.dato = info;
        n.sig = n;
        if (listavacia()) {
            cab = n;
        } else {
            q = cab;
            n.sig = cab;
            while (q.sig != cab) {
                q = q.sig;
            }
            q.sig = n;
            cab = n;
        }
        return q;
    }

    public nodo insertar_final(int info) {
        nodo n = new nodo();
        n.dato = info;
        n.sig = n;
        if (listavacia()) {
            cab = n;
        } else {
            q = cab;
            n.sig = cab;
            while (q.sig != cab) {
                q = q.sig;
            }
            q.sig = n;

        }
        return n;
    }

    public void eliminar_inicio() {
        if (listavacia()) {
            System.out.println("lista vacia ");
        } else {
            t = cab;
            while (t.sig != cab) {
                t = t.sig;
            }
            t.sig = t.sig.sig;
            cab = cab.sig;
        }
    }

    public void eliminar_final() {
        if (listavacia()) {
            System.out.println("lista vacia ");
        } else {
            t = cab;
            m = null;
            aux = null;
            while (t.sig != cab) {
                aux = m;
                m = t;
                t = t.sig;
            }
            m.sig = cab;
        }
    }
    public nodo invertir_lista() {
        if (listavacia() || cab.sig == null) {
            System.out.println("no hay suficientes nodos");
        } else {
            cab2 = null;
            ultimo = null;
            while (cab.sig != ultimo) {
                p = cab;
                q = null;
                while (p.sig != ultimo) {
                    q = p;
                    p = p.sig;
                }
                if (ultimo == null) {
                    cab2 = p;
                }
                p.sig = q;
                ultimo = p;
            }
            cab.sig = cab2;
            cab = cab2;
        }
        return cab;
    }

    public void mostrarlista() {
        if (listavacia()) {
            System.out.print("la lista esta vacia ");
        } else {
            nodo r = cab;

           while (r.sig!= cab) {
                System.out.print("->");
                System.out.print(r.dato + " -> ");
                r = r.sig;
          }
           System.out.print(r.dato + " -> ");
                
        
    }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("LISTAS ENLAZADAS CIRCULARES  ");
        System.out.println("MARTIN CANTILLO ");
        Listas_circulares listas = new Listas_circulares();
        int opc, num, dato;
        do {
            System.out.println("\nMENÚ listas enlazadas circulares ");
            System.out.println("1. Insertar elemento al incio ");
            System.out.println("2.Insertar elemento al final ");
            System.out.println("3. Muestre la lista");
            System.out.println("4.Eliminar nodo al  inicio ");
            System.out.println("5.Eliminar nodo al final ");
            System.out.println("6.Invertir lista ");
            System.out.println("10. Salir");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    num = rnd.nextInt(100);
                    listas.insertar_inicio(num);
                    break;
                case 2:
                    num = rnd.nextInt(100);
                    listas.insertar_final(num);
                case 3:
                    listas.mostrarlista();
                    break;
                case 4:
                    listas.eliminar_inicio();
                    break;
                case 5:
                    listas.eliminar_final();
                    break;
                case 6 : 
                    listas.invertir_lista();
                    break;

            }
        } while (opc != 10);
    }

}
