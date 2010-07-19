/**
 * 
 */
package net.frontlinesms.data.domain;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author Alex Anderson <alex@frontlinesms.com>
 */
@Entity
public class FrontlineMultimediaMessage extends FrontlineMessage {
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<FrontlineMultimediaMessagePart> multimediaParts;
	
	FrontlineMultimediaMessage() {}
	public FrontlineMultimediaMessage(Type type, String textContent, List<FrontlineMultimediaMessagePart> multimediaParts) {
		super(type, textContent);
		this.multimediaParts = multimediaParts;
	}
	
	public List<FrontlineMultimediaMessagePart> getMultimediaParts() {
		return Collections.unmodifiableList(this.multimediaParts);
	}
	public boolean hasBinaryPart() {
		for (FrontlineMultimediaMessagePart part : this.multimediaParts) {
			if (part.isBinary()) {
				return true;
			}
		}
		
		return false;
	}
}