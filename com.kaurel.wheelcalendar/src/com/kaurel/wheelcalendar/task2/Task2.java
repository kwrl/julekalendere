package com.kaurel.wheelcalendar.task2;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public class Task2 {
	public static void main(String[] args) {
		new Task2();
	}

	public Task2() {
		System.out.println(StreamSupport
				.stream(new FibonacciGenerator(4000000000L), false)
				.filter(fib -> fib % 2 == 0)
				.mapToLong(Long::longValue)
				.sum());
	}

	class FibonacciGenerator implements Spliterator<Long> {
		private final long limit;
		private long x, y;

		public FibonacciGenerator(long limit) {
			this.limit = limit;
			this.x = 0;
			this.y = 1;
		}		
		
		@Override
		public boolean tryAdvance(Consumer<? super Long> action) {
			if(y < limit) {
				long temp = y;
				y = y + x;
				x = temp;
				action.accept(x);
				return true;
			}
			return false;
		}

		@Override
		public Spliterator<Long> trySplit() {
			return null;
		}

		@Override
		public long estimateSize() {
			return Long.MAX_VALUE;
		}

		@Override
		public int characteristics() {
			return Spliterator.ORDERED;
		}

	};

}
