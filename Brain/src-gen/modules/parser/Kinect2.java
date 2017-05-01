package modules.parser;

import java.io.Serializable;

import main.*;
import modules.Module;

public class Kinect2 implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	// Parsed information
	private boolean noiseDetected;
	private boolean personDetected;
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
			
		}else if(datas[0].equals("PERSON")){
			String[] waveDatas = datas[1].split(";");
			if (waveDatas[0].contains("1")) {
				System.out.println("Kinect2: Person detected (x: " + waveDatas[2] + ", y: " + waveDatas[3] + ", Wiving: " + waveDatas[1] + ")");
				this.setWavingX(Double.parseDouble(waveDatas[2]));
				this.setWavingY(Double.parseDouble(waveDatas[3]));
				this.setWavingDetected(waveDatas[1].equals("1"));
				this.setPersonDetected(true);
			} else {
				System.out.println("Kinect2: No Person");
				this.setWavingX(-1);
				this.setWavingY(-1);
				this.setWavingDetected(false);
				this.setPersonDetected(false);
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
	
	
	
	public boolean isPersonDetected() {
		return personDetected;
	}

	public void setPersonDetected(boolean personDetected) {
		this.personDetected = personDetected;
		
		if (personDetected) {
			start.getStatemachine().raiseEventOfSCI("Kinect2","personDetected");
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
		this.personDetected = false;
		this.noiseDetected = false;
		this.wavingDetected = false;
		this.noiseAngle = -1;
		this.wavingX = -1;
		this.wavingY = -1;
		return true;
	}

}