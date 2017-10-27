package middle;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public class PartitionList {
	public ListNode partition(ListNode head, int x){
		ListNode dumy1 = new ListNode(0);
		ListNode dumy2 = new ListNode(0);
		ListNode cur1 = dumy1;
		ListNode cur2 = dumy2;
		while(head!=null){
			if(head.val < x){
				cur1.next = head;
				cur1 = cur1.next;
			}else{
				cur2.next = head;
				cur2 = cur2.next;
			}
			head = head.next;
		}
		cur2.next = null;
		cur1.next = dumy2.next;
		return dumy1.next;
	}
	public static void main(String[] args){
		PartitionList p = new PartitionList();
		int x = 5;
		ListNode head = new ListNode(0);
		ListNode tail = head;
		for(int i = 0;i<5;i++){
			ListNode tempNode = new ListNode(i);
			head.next = tempNode;
			head = head.next;
		}
		head.next = null;
		p.partition(tail, x);
		while(tail != null){
			System.out.println(tail.val);
			tail = tail.next;
		}
	}
	
}
