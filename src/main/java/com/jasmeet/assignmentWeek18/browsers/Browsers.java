package com.jasmeet.assignmentWeek18.browsers;

public enum Browsers {

		CHROME("chrome"),
		EDGE("edge"),
		FIREFOX("firefox");
		
		String browserName;

		private Browsers(String name) {
			this.browserName = name;
		}

		public String getBrowserName() {
			return browserName;
		}
}
