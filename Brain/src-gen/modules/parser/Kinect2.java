package modules.parser;

import java.io.Serializable;

import main.*;
import modules.Module;

public class Kinect2 implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	// Parsed information
	private boolean noiseDetected;
	private boolean wavingDetected;
	private int noiseAngle;
	private double wavingX;
	private double wavingY;
	
	public boolean parse(String data, Start start) {
		this.start = start;
		// NOISE#[FoundNoise:1/0];[ANGLE_BODY:int];[ANGLE_NOISE:int]#
		// WAVE#[FoundWave:1/0];[HEAD_X:double];[HEAD_Y:double]#

		String[] datas = data.split("#");
		
		if (datas[0].equals("NOISE")) {
			String[] noiseDatas = datas[1].split(";");
			if (noiseDatas[0].contains("1")) {
				System.out.println("Noise detected: " + noiseDatas[1]);
				this.setNoiseAngle(Integer.parseInt(noiseDatas[1]));
				this.setNoiseDetected(true);
			} else {
				//System.out.println("No noises");
				this.setNoiseDetected(false);
			}
			
		}else if(datas[0].equals("WAVE")){
			String[] waveDatas = datas[1].split(";");
			if (waveDatas[0].contains("1")) {
				System.out.println("Waving detected: " + waveDatas[1] + "; " + waveDatas[2]);
				this.setWavingX(Double.parseDouble(waveDatas[1]));
				this.setWavingY(Double.parseDouble(waveDatas[2]));
				this.setWavingDetected(true);
			} else {
				//System.out.println("No waving");
				this.setWavingDetected(false);
			}
		}
		
		
		return true;
		
	}

	public boolean isNoiseDetected() {
		return noiseDetected;
	}

	public void setNoiseDetected(boolean noiseDetected) {
		this.noiseDetected = noiseDetected;
		
		if (noiseDetected) {
			start.getStatemachine().raiseEventOfSCI("Kinect2","noiseDetected");
		}
	}
	
	public boolean isWavingDetected() {
		return wavingDetected;
	}

	public void setWavingDetected(boolean wavingDetected) {
		this.wavingDetected = wavingDetected;
		
		if (wavingDetected) {
			start.getStatemachine().raiseEventOfSCI("Kinect2","wavingDetected");
		}
		
	}

	public int getNoiseAngle() {
		return noiseAngle;
	}

	public void setNoiseAngle(int noiseAngle) {
		this.noiseAngle = noiseAngle;
	}

	public double getWavingX() {
		return wavingX;
	}

	public void setWavingX(double wavingX) {
		this.wavingX = wavingX;
	}

	public double getWavingY() {
		return wavingY;
	}

	public void setWavingY(double wavingY) {
		this.wavingY = wavingY;
	}

	public boolean removeParsedInformation() {
		this.noiseDetected = false;
		this.wavingDetected = false;
		this.noiseAngle = -1;
		this.wavingX = -1;
		this.wavingY = -1;
		return true;
	}

}