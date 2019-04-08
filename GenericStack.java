/**
 * LISTA GENERICA
 */
public class GenericStack<T> {
	private GenericNode<T> first;
	private GenericNode<T> current;
	private GenericNode<T> prev;

    public GenericStack() {
		first = null;
		prev = null;
		current = null;
    }

    public boolean empty() {
		return first == null;
	}
	
	

    public void add(T x) {
		first = new GenericNode<>(x, first);
		if ((current == first.next) && (current != null))  {
			prev = first;
		}
	}
	
	public void setIteration(){
		current = first;
		prev = null;
	}

	public boolean hasNext(){
		return current != null;	
	}

	public void next(){
		if(current != null){
			prev = current;
			current = current.next;
		}
	}

    public void cancel() {
		if (empty()) throw new IllegalStateException("empty stack");
		else if (current != null && prev != null ){
			prev.next = current.getNext();
			current = current.getNext();
		}
		else {
			first = current.getNext();
			current = first;
			System.out.println("else");
		} 
	}

	public int length(){
		int c = 0;
		if(first == null)
			System.out.println("null");
		else{
			GenericNode curr = first;
			while(curr != null){
				c++;
				curr = curr.getNext();
			}
	}
		return c;
	}


	public T getData(){
		T result = null;
		if(current != null){
			result = current.elem;
		}
		else {
			System.out.println("null");
		}
		return result;
	}

	public GenericNode getCurrent(){
		GenericNode t = current;
		return t;
	}



	

public class GenericNode<T> { 
  private T elem;
  private GenericNode<T> next;

  public GenericNode(T elem, GenericNode<T> next){
    this.elem= elem;
    this.next = next;
  }

  public T getElem(){
    return elem;
  }

  public GenericNode<T> getNext(){
    return next;
  }
  

}

	
}
