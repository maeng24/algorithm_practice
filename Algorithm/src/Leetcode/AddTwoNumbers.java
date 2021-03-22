package Leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode answer = new ListNode();
		ListNode curnode = answer;
		boolean up = false;

		// 첫 노드
		curnode.val = (l1.val + l2.val) % 10;
		if (up) {
			curnode.val += 1;
			up = false;
		}
		if (l1.val + l2.val >= 10) {
			up = true;
		}

		while (true) {
			if (l1.next == null && l2.next == null && !up) {
				break;
			}

			curnode.next = new ListNode();
			curnode = curnode.next;
			if (l1.next != null && l2.next != null) {

				l1 = l1.next;
				l2 = l2.next;

				curnode.val = l1.val + l2.val;
				if (up) {
					curnode.val += 1;
					up = false;
				}
				if (curnode.val >= 10) {
					curnode.val = curnode.val % 10;
					up = true;
				}
			} else if (l1.next != null) {// l1만 다음 노드가 있을 때

				l1 = l1.next;

				curnode.val = l1.val;
				if (up) {
					curnode.val += 1;
					up = false;
				}
				if (curnode.val >= 10) {
					curnode.val = curnode.val % 10;
					up = true;
				}
			} else if (l2.next != null) {// l2만 다음 노드가 있을 때

				l2 = l2.next;

				curnode.val = l2.val;
				if (up) {
					curnode.val += 1;
					up = false;
				}
				if (curnode.val >= 10) {
					curnode.val = curnode.val % 10;
					up = true;
				}
			} else {// 두 노드 다 없지만 올림이 있을 때
				up = false;
				curnode.val = 1;
			}
		}
		return answer;
	}
}
