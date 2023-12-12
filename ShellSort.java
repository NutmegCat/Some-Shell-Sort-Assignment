// Aaron Prince Anu

class ShellSort {
    public static void main(String[] args) {
        int[] list = new int[500];
        for (int x = 0; x < 500; x++) {
            list[x] = (int) (1000 * Math.random());
        }

        System.out.println("Initial list");
        printList(list);

        shellSort(364, list);

        System.out.println("\nSorted list");
        printList(list);
    }

    public static void shellSort(int k, int[] list) {
        System.out.println();

        for (int space = k; space > 0; space /= 2) {

            for (int i = 0; i < space; i++) {

                int subListLength = (list.length - i + space - 1) / space;

                double[] subList = new double[subListLength];

                for (int j = i, index = 0; j < list.length; j += space, index++) {
                    subList[index] = list[j];
                }

                insertSort(subList);

                for (int j = i, index = 0; j < list.length; j += space, index++) {
                    list[j] = (int) subList[index];
                }
            }
        }
    }

    public static void insertSort(double[] list) {
        for (int top = 1; top < list.length; top++) {
            double item = list[top];
            int i = top;
            while (i > 0 && item < list[i - 1]) {
                list[i] = list[i - 1];
                i--;
            }
            list[i] = item;
        }
    }

    public static void printList(int[] list) {
        for (int y = 0; y < list.length; y++) {
            if ((y + 1) % 10 == 0) {
                System.out.println(list[y] + " ");
            } else {
                System.out.print(list[y] + " ");
            }
        }
    }
}