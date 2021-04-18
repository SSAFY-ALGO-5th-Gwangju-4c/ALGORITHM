package com.ssafy.ilta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		/*
		int sum,cnt=0;
		for(int i=0;i<N;i++) {
			sum=0;
			for(int j=i;j<N;j++) {
				sum+=arr[j];
				if(sum>M) break;
				if(sum==M) {
					cnt++;
					break;
				}
			}
		}
		*/
		
		int sum = 0,cnt = 0,e = 0,s = 0;
		while(true) {
			if(sum<M) {
				if(e>=N) break;
				sum += arr[e++];
			}else {
				sum -= arr[e++];
			}
			if(sum==M) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
