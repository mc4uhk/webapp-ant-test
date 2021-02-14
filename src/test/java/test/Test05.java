package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Test05 {

	@Test
	void test() {
		String str = getRandomHexString(4)+"-"+getRandomHexString(4);
		log.info("Hi: {}",str);
		
		assertTrue(true,"Test Passed");
	}
	
    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }	
}
