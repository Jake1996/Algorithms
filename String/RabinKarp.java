package String;

public class RabinKarp {
	static final long mod = 1000000007;
	static final long mul = 256;
	public static int findPatternInText(char text[],char pattern[],int start ,int end) {
		int length = pattern.length;
		long hash = 0;
		long primepow = 1;
		long currentHash=0;
		for(int i=0;i<length;i++) {
			hash = (hash*mul+pattern[i])%mod;
		}
		for(int i=1;i<length;i++) {
			primepow = (mul*primepow)%mod;
		}
		int i;
		for(i=start;i<=end&&i<(start+length);i++) {
			currentHash = (currentHash*mul+text[i])%mod;

		}
		if(currentHash == hash) {
			int j;
			for(j=0;j<length;j++)
				if(pattern[j]!=text[i-length+j])
					break;
			if(j==length)
				return i-length;
		}
		for(i = start+length;i<=end;i++) {
			currentHash = (currentHash+mod - (primepow*text[i-length])%mod)%mod;
			currentHash = (currentHash*mul+text[i])%mod;
			if(currentHash==hash) {
				int j;
				for(j=0;j<length;j++)
					if(pattern[j]!=text[i-length+1+j])
						break;
				if(j==length)
					return i-length+1;
			}
		}
		return -1;
	}
	public static int findPatternInText(char text[],char pattern[]) {
		return findPatternInText(text, pattern, 0, text.length-1);
	}
	public static int findPatternInText(char text[],char pattern[],int start) {
		return findPatternInText(text, pattern, start, text.length-1);
	}
	public static int occurances(char text[],char pattern[],int start ,int end) {
		int occ = 0;
		int length = pattern.length;
		long hash = 0;
		long primepow = 1;
		long currentHash=0;
		for(int i=0;i<length;i++) {
			hash = (hash*mul+pattern[i])%mod;
		}
		for(int i=1;i<length;i++) {
			primepow = (mul*primepow)%mod;
		}
		int i;
		for(i=start;i<=end&&i<(start+length);i++) {
			currentHash = (currentHash*mul+text[i])%mod;

		}
		if(currentHash == hash) {
			int j;
			for(j=0;j<length;j++)
				if(pattern[j]!=text[i-length+j])
					break;
			if(j==length)
				occ++;
		}
		for(i = start+length;i<=end;i++) {
			currentHash = (currentHash+mod - (primepow*text[i-length])%mod)%mod;
			currentHash = (currentHash*mul+text[i])%mod;
			if(currentHash==hash) {
				int j;
				for(j=0;j<length;j++)
					if(pattern[j]!=text[i-length+1+j])
						break;
				if(j==length)
					occ++;
			}
		}
		return occ;
	}
}
