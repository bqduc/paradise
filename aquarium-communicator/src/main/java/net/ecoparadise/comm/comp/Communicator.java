/**
 * 
 */
package net.ecoparadise.comm.comp;

import net.ecoparadise.comm.domain.CorpMimeMessage;
import net.ecoparadise.exceptions.CommunicatorException;
import net.ecoparadise.model.ExecutionContext;

/**
 * @author ducbq
 *
 */
public interface Communicator {
	void sendEmail(CorpMimeMessage mailMessage) throws CommunicatorException;
	void send(ExecutionContext context) throws CommunicatorException;
}
