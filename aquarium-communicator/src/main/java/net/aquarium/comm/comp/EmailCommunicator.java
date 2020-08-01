/**
 * 
 */
package net.aquarium.comm.comp;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import net.aquarium.comm.domain.CorpMimeMessage;
import net.aquarium.exceptions.CommunicatorException;
import net.aquarium.model.ExecutionContext;

/**
 * @author ducbq
 *
 */
@Component(value="emailCommunicator")
public class EmailCommunicator implements Communicator {

	@Inject 
	private CommunicatorServiceHelper communicatorServiceHelper;

	@Override
	public void sendEmail(CorpMimeMessage mailMessage) throws CommunicatorException {
		System.out.println("net.paramount.comm.component.EmailServiceImpl.send(MailMessage)");
	}

	@Override
	public void send(ExecutionContext context) throws CommunicatorException {
		communicatorServiceHelper.sendEmail(context);
	}
}
