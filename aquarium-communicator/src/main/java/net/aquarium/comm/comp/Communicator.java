/**
 * 
 */
package net.aquarium.comm.comp;

import net.aquarium.comm.domain.CorpMimeMessage;
import net.aquarium.exceptions.CommunicatorException;
import net.aquarium.model.ExecutionContext;

/**
 * @author ducbq
 *
 */
public interface Communicator {
	void sendEmail(CorpMimeMessage mailMessage) throws CommunicatorException;
	void send(ExecutionContext context) throws CommunicatorException;
}
