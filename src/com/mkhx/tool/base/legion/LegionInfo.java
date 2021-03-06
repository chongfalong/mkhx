package com.mkhx.tool.base.legion;

public class LegionInfo extends com.mkhx.tool.base.ToolBase {
	protected String requestHost = super.defaultDestHost;
	protected String requestPath = super.legionInfoPath;
	protected String requestURL = super.defaultDestHost + super.legionInfoPath;
	protected String requestBody = null;
	protected String cookie = null;
	protected String responseText = null;

	public LegionInfo(String cookie) {
		this.cookie = cookie;
	}

	public LegionInfo(String cookie, String requestHost) {
		this.cookie = cookie;
		this.requestHost = requestHost;
		this.requestURL = this.requestHost + this.requestPath;
	}

	public LegionInfoResponse request() {
		String response[] = super.request(requestURL, cookie, requestBody);
		this.responseText = response[0];
		this.cookie = response[1];
		if(this.responseText!=null && !this.responseText.equals("")){
			return new LegionInfoResponse(this.responseText);
		}else{
			return null;
		}
	}

	public String getCookie() {
		return this.cookie;
	}

	public String getResponseText() {
		return this.responseText;
	}
}
