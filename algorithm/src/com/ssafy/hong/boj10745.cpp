#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>

using namespace std;
const int MAX=27, M=100002;
char str[M];


struct Trie{
	Trie* next[MAX], *fail;
	bool finish;
	int length;
	Trie(){fill(next,next+MAX,nullptr); fail=nullptr; finish=false; length=0;}
	~Trie(){for(int i=0; i<MAX; i++)if(next[i])delete next[i];}

	void insert(string str){
		Trie* temp = this;
		for(auto c : str){
			int idx = c-'a';
			if(temp->next[idx]==nullptr)temp->next[idx]=new Trie();
			temp=temp->next[idx];
		}
		temp->finish=true;
		temp->length=str.size();
	}
};

void makeFail(Trie* root){
	queue<Trie*> q;
	q.push(root);
	root->fail=root;

	while(!q.empty()){
		Trie * curr=q.front(); q.pop();
		for(int i=0; i<MAX; i++){
			Trie * next = curr->next[i];
			Trie * fail = curr->fail;
			if(next==nullptr)continue;
			if(curr==root)next->fail=root;
			else{
				while(fail->next[i] == nullptr && fail != root) fail=fail->fail;
				if(fail->next[i]) fail=fail->next[i];
				next->fail=fail;
			}
			if(next->fail->finish){
				next->finish=true;
				next->length=next->fail->length;
			}
			q.push(next);
		}
	}
	for(int i=0; i<MAX; i++){
		if(root->next[i])q.push(root->next[i]);
		else root->next[i]=root;
	}
	while(!q.empty()){
		Trie* curr = q.front();
		q.pop();
		for(int i=0; i<MAX; i++){
			if(curr->next[i])q.push(curr->next[i]);
			else curr->next[i]=curr->fail->next[i];
		}
	}
}

void getAns(Trie* root, string& s){
	int idx=0, size =s.size();
	vector<Trie*> vTrie(size);
	
	Trie* curr = root;
	vTrie[idx++] = root;

	for(int i=0; i<size; i++){
		int indx = s[i]-'a';
		while(curr->next[indx] == nullptr && curr!=root){
			curr=curr->fail;
		}
		if(curr->next[indx]){
			curr=curr->next[indx];
		}

		vTrie[idx] = curr;
		str[idx++-1] = s[i];

		if(curr->finish){
			idx-=curr->length;
			curr=vTrie[idx-1];
		}
	}
	str[idx-1]='\0';
	cout<<str;
}
int main(void){
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	Trie* root = new Trie();
	int N;
	string S,t; 
	cin>>S>>N;

	for(int i=0; i<N; i++){
		cin>>t;
		root->insert(t);
	}
	makeFail(root);
	getAns(root,S);
	return 0;
}
