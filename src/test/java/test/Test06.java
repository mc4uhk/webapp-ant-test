package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hk.mc4u.CacheHelper;
import hk.mc4u.SquaredCalculator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test06 {
	CacheHelper cacheHelper;
	SquaredCalculator squaredCalculator;

	
//    @Test
    @DisplayName(value = "simple test")
    public void shouldAnswerWithTrue() {
    	Integer i = (new Random()).nextInt(100);
    	assertThat(i)
    		.isNotNull()
    		.isNotNegative()
    		.isLessThan(100)
    		.isEven();
    	
    }

    @BeforeEach
    public void init() {
    	cacheHelper = new CacheHelper();
		squaredCalculator = new SquaredCalculator(cacheHelper);
	}
    
    @Test
    public void whenCalculatingSquareValueAgain_thenCacheHasAllValues() {
    	
        for (int i = 10; i < 15; i++) {
        	Assertions.assertFalse(cacheHelper.getSquareNumberCache().containsKey(i));
            log.info("Square value of " + i + " is: "
              + squaredCalculator.getSquareValueOfNumber(i) + "\n");
        }      
        
        for (int i = 10; i < 15; i++) {
        	Assertions.assertTrue(cacheHelper.getSquareNumberCache().containsKey(i));
        	log.info("Square value of " + i + " is: "
              + squaredCalculator.getSquareValueOfNumber(i) + "\n");
        }
    }
    

    @AfterEach
    public void destory() {
    	cacheHelper.close();
    }
}
