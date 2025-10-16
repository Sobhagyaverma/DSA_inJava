package Arrays;

public int minimumDeletions(int[]nums){if(nums.length==1)return 1;if(nums.length==2)return 2;int max=Integer.MIN_VALUE;int min=Integer.MAX_VALUE;int maxind=0;int minind=0;

for(int i=0;i<nums.length;i++){if(nums[i]>max){max=nums[i];maxind=i;}if(nums[i]<min){min=nums[i];minind=i;}}int n=nums.length;

int first=Math.min(minind,maxind)+1;int second=Math.max(minind,maxind)+1;

int case1=second;

int case2=n-Math.min(minind,maxind);

int case3=first+(n-Math.max(minind,maxind));

int res=Math.min(case1,Math.min(case2,case3));return res;}
