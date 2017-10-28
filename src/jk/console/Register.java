package jk.console;

import java.util.ArrayList;
import java.util.List;

import jk.domain.EllipseCurve;

public class Register {

	private List<EllipseCurve> ellipseCurves = new ArrayList<>();
	private EllipseCurve currentEC;

	public EllipseCurve getCurrentEC() {
		return currentEC;
	}

	public EllipseCurve getEC(int i) {
		if (i<0 || i>ellipseCurves.size()-1)
			return null;
		currentEC = ellipseCurves.get(i);
		return currentEC;
	}

	public void setCurrentEC(EllipseCurve newCurrentEC) {
		if (!ellipseCurves.contains(newCurrentEC))
			ellipseCurves.add(newCurrentEC);
		this.currentEC = newCurrentEC;
	}

	public boolean addEllipseCurve(EllipseCurve ec){
		if (!ellipseCurves.contains(ec)){
			ellipseCurves.add(ec);
			return true;
		} else
			return false;
	}
}
