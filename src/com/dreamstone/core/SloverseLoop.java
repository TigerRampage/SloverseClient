package com.dreamstone.core;

public class SloverseLoop implements Runnable {
	
	private static final int TICKS_PER_SECOND = 60;
	private static final double SECONDS_PER_TICK = (1 / (double)TICKS_PER_SECOND);
	
	private int ticks;
	private int frames;
	
	private double last;
	private double now;
	private double delta;
	private double lag;
	
	private Thread gameThread;
	private boolean isRunning;
	
	public SloverseLoop() {
		isRunning = false;
	}

	public void start() {
		if (isRunning) {
			//Log message!
			return;
		}
		else {
			setRunning(true);
			gameThread = new Thread(this);
			gameThread.start();
		}
	}
	
	public void stop() {
		if (!isRunning) {
			//Log message!
			return;
		}
		else {
			setRunning(false);
		}
	}
	
	private void processInput() {
		
	}
	
	private void render(double lerp) {
		frames++;
	}
	
	private void update() {
		ticks++;
	}
	
	@Override
	public void run() {
		
		last = System.nanoTime();
		while (isRunning) {
			
			now = System.nanoTime();
			delta = (now - last) / 1000000000d;
			
			last = now;
			lag += delta;
			
			if (lag > 0.15d) {
				lag = 0.15d;
			}
			
			processInput();
			while (lag > SECONDS_PER_TICK) {
				update();
				lag -= SECONDS_PER_TICK;
				
				if (ticks % TICKS_PER_SECOND == 0) {
					System.out.println("Ticks: " + ticks + " | Frames: " + frames);
					ticks = 0;
					frames = 0;
				}
			}
			render(lag / SECONDS_PER_TICK);
		}
	}
	
	private void setRunning(boolean b) {
		isRunning = b;
	}
	
	public boolean isRunning() {
		return isRunning;
	}
}
