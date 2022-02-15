#include <cstdio>
#include <vector>
#include <cstring>
#include <stack>

using namespace std;
const int MAX=300002;
char src[27], dst[MAX];
char ans[MAX];
int main(void){
	scanf("%s %s ",src,dst);
	int N = strlen(dst), M=strlen(src);
	vector<char> fr,br;

	int i=0, j=N-1;
	bool isFirst=true;	
	while(i<=j){
		if(isFirst){
			fr.push_back(dst[i++]);
			int size=fr.size();
			if(size>=M){
				bool check = true;
				for(int i=size-M, j=0; i<size ;i++){
					if(fr[i]!=src[j++]){check = false; break;}
				}
				if(check){
					for(int i=0; i<M; i++)fr.pop_back();
					isFirst=!isFirst;
				}
			}
		}
		else{
			br.push_back(dst[j--]);
			int size=br.size();
			if(size>=M){
				bool check = true;
				for(int i=size-1, j=0; i>=size-M; i--){
					if(br[i]!=src[j++]){check=false;break;}
				}
				if(check){
					for(int i=0; i<M; i++)br.pop_back();
					isFirst=!isFirst;
				}
			}
		}
	}
	int idx=br.size()-1;

	while(idx>=0){
		fr.push_back(br[idx--]);
		int size=fr.size();
		if(size>=M){
			bool check=true;
			for(int i=size-M, j=0; i<size; i++){
				if(src[j++]!=fr[i]){check=false;break;}
			}
			if(check){
				for(int i=0; i<M; i++)fr.pop_back();
			}
		}
	}
	for(int i=0; i<fr.size(); i++)ans[i]=fr[i];
	ans[fr.size()]='\0';
	printf("%s",ans);
	return 0;
}
