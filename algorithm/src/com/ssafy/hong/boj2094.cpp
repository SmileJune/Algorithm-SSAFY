#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

const int MAX=1<<18, S=1<<17;

int N,seg[MAX];
vector<int> v;

int get(int l, int r, int n=1, int s=0, int e=S-1){
	if(r<s || e<l)return -1;
	if(l<=s&&e<=r)return seg[n];
	int mid=(s+e)/2;
	return max(get(l,r,n*2,s,mid),get(l,r,n*2+1,mid+1,e));
}
void print(int n){
	printf("%s\n",n==0?"false":n==1?"true":"maybe");
}

int verify(int y, int x){
	int yy = lower_bound(v.begin(), v.end(), y)-v.begin();
	int xx = lower_bound(v.begin(), v.end(), x)-v.begin();
	
	
	bool isExsistX = xx<N && v[xx]==x;
	bool isExsistY = yy<N && v[yy]==y;
	bool isContinous = isExsistX && isExsistY && yy-xx == y-x;
	
	int res=get(yy+(isExsistY?1:0),xx-1);
	if(isExsistY && isExsistX){
		if(seg[S+yy] < seg[S+xx] || res >= seg[S+xx]) return 0;
		if(isContinous) return 1;
	}
	else if(isExsistX){
		if(seg[S+xx] <= res) return 0;
	}
	else if(isExsistY){
		if(seg[S+yy] <= res)return 0;
	}
	return 2;
}

int main(void){
	scanf("%d ",&N);
	for(int i=0; i<N; i++){
		int y,r;scanf("%d %d ",&y,&r);
		v.push_back(y);
		seg[i+S]=r;
	}
	for(int i=S-1; i>0; i--){
		seg[i]=max(seg[i*2],seg[i*2+1]);
	}

	int Q;scanf("%d ", &Q);
	while(Q--){
		int y,x; scanf("%d %d ",&y,&x);
		print(verify(y,x));
	}
}
