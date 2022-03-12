#include <cstdio>

using namespace std;

int main(void){
  int N,M,K; scanf("%d %d %d ",&N,&M,&K);
  int arr[N];
  int cnt = N/M;
  int tmp = K-(N/M+(N%M>0?1:0));
  int temp = N;
  for(int i=0; i<N; i+=M){
    for(int j=i+M-1; j<N&&j>=i; j--){
      arr[j] = temp--;
    }
  }
  for(int i=N-1; i>=N-N%M; i--) arr[i] = temp--;
  
  if(tmp > 0 && N%M > 0){
    int ccnt;
    if(tmp >= N%M) ccnt = (N%M)-1;
    else ccnt = tmp;
    for(int i = N-ccnt-1, j=N-1; i<j; i++,j--){
      int t = arr[i];
      arr[i]=arr[j];
      arr[j]=t;
    }
    tmp-=ccnt;
  }
  cnt--;
  while(tmp>0 && cnt>-1){
    int ccnt;
    if(M>tmp) ccnt = tmp;
    else ccnt = M-1;
    for(int i=M*cnt, j=M*cnt+ccnt; i<j; i++,j--){
      int t = arr[i];
      arr[i]=arr[j];
      arr[j]=t;
    }
    tmp-=ccnt;
    cnt--;
  }
  if(cnt == -1 || tmp < 0)printf("-1");
  else for(int i=0; i<N; i++)printf("%d ",arr[i]);

  return 0;
}
