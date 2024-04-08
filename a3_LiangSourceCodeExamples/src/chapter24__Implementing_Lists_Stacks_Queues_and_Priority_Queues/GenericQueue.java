package a3_LiangSourceCodeExamples.src.chapter24__Implementing_Lists_Stacks_Queues_and_Priority_Queues;


public class GenericQueue<E> {
  private java.util.LinkedList<E> list 
    = new java.util.LinkedList<E>();

  public void enqueue(E e) {
    list.addLast(e);
  }

  public E dequeue() {
    return list.removeFirst();
  }

  public int getSize() {
    return list.size();
  }

  @Override
  public String toString() {
    return "Queue: " + list.toString();
  }
}
