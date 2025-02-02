//{ Driver Code Starts
#include <bits/stdc++.h>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

struct Node {
    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

/* Function to print linked list */
void printList(Node* node) {
    while (node != NULL) {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
}


// } Driver Code Ends
/*
  Node is defined as
    struct node
    {
        int data;
        struct Node* next;

        Node(int x){
            data = x;
            next = NULL;
        }

    }*head;
*/

class Solution {
  public:
  int count_(Node*head){
        int c=0;
        Node*temp = head;
        while(temp!=NULL){
            c++;
            temp = temp->next;
        }
        return c;
    }
    Node *reverseKGroup(Node *head1, int k) {
        // code here
        Node *head = NULL;
        Node *tail = NULL;
        Node *tail1 = NULL;
        Node *h = NULL;
        Node *temp = head1;
        int count=0 , p=1;
        while(temp!=NULL){
            if(count<k){
                Node *newnode = new Node(temp->data);
                if(h==NULL){
                    tail = newnode;
                    h = newnode;
                }
                else{
                    newnode->next  = h;
                    h = newnode;   
                }
            }
            count++;
            temp = temp->next;
            if(count==k){
                if(p==1){
                    head = h;
                    tail1 = tail;
                    p++;
                }
                else{
                    tail1->next = h;
                    tail1 = tail;
                }
                tail = NULL;
                h = NULL;
                count=0;
            }
        }
        int s=count_(head1);
        if(s<k){
            head = h;
            tail1 = tail;
        }
        else if(s%k!=0){
            tail1->next = h;
            tail1 = tail;
        }
        
        return head;
    }
};



//{ Driver Code Starts.

/* Driver program to test above function*/
int main(void) {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {

        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        if (arr.empty()) {
            cout << -1 << endl;
            continue;
        }

        int data = arr[0];
        Node* head = new Node(data);
        Node* tail = head;
        for (int i = 1; i < arr.size(); ++i) {
            data = arr[i];
            tail->next = new Node(data);
            tail = tail->next;
        }
        int k;
        cin >> k;
        cin.ignore();

        Solution ob;
        head = ob.reverseKGroup(head, k);
        printList(head);
        cout << "~" << endl;
    }

    return 0;
}
// } Driver Code Ends