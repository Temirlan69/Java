package com.company;
import java.util.ArrayList;

   public class Heap {
        void heapify(ArrayList<Integer> hT, int i) {
            int size = hT.size();
            int largest = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < size && hT.get(l) > hT.get(largest))
                largest = l;
            if (r < size && hT.get(r) > hT.get(largest))
                largest = r;

            if (largest != i) {
                int temp = hT.get(largest);
                hT.set(largest, hT.get(i));
                hT.set(i, temp);

                heapify(hT, largest);
            }
        }

        void add(ArrayList<Integer> hT, int newNum) {
            int size = hT.size();
            if (size == 0) {
                hT.add(newNum);
            } else {
                hT.add(newNum);
                for (int i = size / 2 - 1; i >= 0; i--) {
                    heapify(hT, i);
                }
            }
        }

        void removeNode(ArrayList<Integer> hT, int num)
        {
            int size = hT.size();
            int i;
            for (i = 0; i < size; i++)
            {
                if (num == hT.get(i))
                    break;
            }

            int temp = hT.get(i);
            hT.set(i, hT.get(size-1));
            hT.set(size-1, temp);

            hT.remove(size-1);
            for (int j = size / 2 - 1; j >= 0; j--) {
                heapify(hT, j);
            }
        }
    }

//       private void heapify(int pos) {
//           if (isLeaf(pos))
//               return;
//
//           if (Heap[pos] < Heap[leftChild(pos)]
//                   || Heap[pos] < Heap[rightChild(pos)]) {
//
//               if (Heap[leftChild(pos)]
//                       > Heap[rightChild(pos)]) {
//                   swap(pos, leftChild(pos));
//                   heapify(leftChild(pos));
//               } else {
//                   swap(pos, rightChild(pos));
//                   heapify(rightChild(pos));
//               }
//           }
//       }
//
//       private int parent(int pos) {
//           return (pos - 1) / 2;
//       }
//
//
//       private int leftChild(int pos) {
//           return (2 * pos) + 1;
//       }
//
//
//       private int rightChild(int pos) {
//           return (2 * pos) + 2;
//       }

