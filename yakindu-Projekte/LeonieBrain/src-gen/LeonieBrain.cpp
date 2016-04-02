
#include "LeonieBrain.h"
#include <string.h>
/*! \file Implementation of the state machine 'LeonieBrain'
*/

LeonieBrain::LeonieBrain() {
	
	ifaceUdpInterface_OCB = null;
	
	stateConfVectorPosition = 0;
	
	timer = null;
}

LeonieBrain::~LeonieBrain() {
}


void LeonieBrain::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = LeonieBrain_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart LeonieBrain */
	ifaceUdpInterface.message = "";
	ifaceACIface_stat.faceID = "";
	ifaceACIface_stat.confidence = 0;
	ifaceACIface_stat.age = 0;
	ifaceACIface_stat.gender = false;
	ifaceACIface_stat.ethnicty = 0;
	ifaceACIface_stat.glasses = false;
	ifaceACIface_stat.attractiveness = 0;
	ifaceACIface_dyn.headGestures = 0;
	ifaceACIface_dyn.speaking = false;
	ifaceACIface_dyn.emotions = "";
	ifaceACIface_dyn.distance = 0;
	ifaceAci.countFoundFaces = 0;
	ifaceKinect.geste = "";
	ifaceLeapMotion.geste = "";
	ifaceScitosRemoteControl.emergencyStop = false;
	ifaceOpenDail.speakerMsg = "";
	ifaceOpenDail.leonieMsg = "";
	ifaceMira.randMove = false;
	ifaceFaceAnimation.emotion = "";
	ifaceInternalSCI.t = 0;

}

void LeonieBrain::enter()
{
	/* Default enter sequence for statechart LeonieBrain */
	enseq__0_default();
}

void LeonieBrain::exit()
{
	/* Default exit sequence for statechart LeonieBrain */
	exseq__0();
}

sc_boolean LeonieBrain::isActive() {
	return stateConfVector[0] != LeonieBrain_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean LeonieBrain::isFinal(){
   return false;}

void LeonieBrain::runCycle() {
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++) {
			
		switch (stateConfVector[stateConfVectorPosition]) {
		case _0_Init : {
			react__0_Init();
			break;
		}
		case _0_FaceDataInterpretation__region0_PersonKnown : {
			react__0_FaceDataInterpretation__region0_PersonKnown();
			break;
		}
		case _0_FaceDataInterpretation__region0_PersonUnknown : {
			react__0_FaceDataInterpretation__region0_PersonUnknown();
			break;
		}
		case _0_TurnToNoise : {
			react__0_TurnToNoise();
			break;
		}
		case _0_Idle : {
			react__0_Idle();
			break;
		}
		case _0_MoveToPerson : {
			react__0_MoveToPerson();
			break;
		}
		case _0_SearchForChar__region0_Standing : {
			react__0_SearchForChar__region0_Standing();
			break;
		}
		case _0_SearchForChar__region0_Walking : {
			react__0_SearchForChar__region0_Walking();
			break;
		}
		case _0_GatherData__region0_ReceiveUDPString : {
			react__0_GatherData__region0_ReceiveUDPString();
			break;
		}
		case _0_GatherData__region0_ParseStringForData : {
			react__0_GatherData__region0_ParseStringForData();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void LeonieBrain::clearInEvents() {
	ifaceInternalSCI.start_raised = false; 
	ifaceInternalSCI.faceFound_raised = false; 
	ifaceInternalSCI.noiseDetected_raised = false; 
	ifaceInternalSCI.textMsg_raised = false; 
	ifaceInternalSCI.onTriggerDataGatherer_raised = false; 
	timeEvents[0] = false; 
	timeEvents[1] = false; 
}

void LeonieBrain::clearOutEvents() {
}


void LeonieBrain::setTimer(TimerInterface* timer){
	this->timer = timer;
}

TimerInterface* LeonieBrain::getTimer(){
	return timer;
}

void LeonieBrain::raiseTimeEvent(sc_eventid evid) {
	if ((evid >= &timeEvents) && (evid < &timeEvents + sizeof(timeEvents))) {
		*(sc_boolean*)evid = true;
	}
}

sc_boolean LeonieBrain::isStateActive(LeonieBrainStates state) {
	switch (state) {
		case _0_Init : 
			return (sc_boolean) (stateConfVector[0] == _0_Init
			);
		case _0_FaceDataInterpretation : 
			return (sc_boolean) (stateConfVector[0] >= _0_FaceDataInterpretation
				&& stateConfVector[0] <= _0_FaceDataInterpretation__region0_PersonUnknown);
		case _0_FaceDataInterpretation__region0_PersonKnown : 
			return (sc_boolean) (stateConfVector[0] == _0_FaceDataInterpretation__region0_PersonKnown
			);
		case _0_FaceDataInterpretation__region0_PersonUnknown : 
			return (sc_boolean) (stateConfVector[0] == _0_FaceDataInterpretation__region0_PersonUnknown
			);
		case _0_TurnToNoise : 
			return (sc_boolean) (stateConfVector[0] == _0_TurnToNoise
			);
		case _0_Idle : 
			return (sc_boolean) (stateConfVector[0] == _0_Idle
			);
		case _0_MoveToPerson : 
			return (sc_boolean) (stateConfVector[0] == _0_MoveToPerson
			);
		case _0_SearchForChar : 
			return (sc_boolean) (stateConfVector[0] >= _0_SearchForChar
				&& stateConfVector[0] <= _0_SearchForChar__region0_Walking);
		case _0_SearchForChar__region0_Standing : 
			return (sc_boolean) (stateConfVector[0] == _0_SearchForChar__region0_Standing
			);
		case _0_SearchForChar__region0_Walking : 
			return (sc_boolean) (stateConfVector[0] == _0_SearchForChar__region0_Walking
			);
		case _0_GatherData : 
			return (sc_boolean) (stateConfVector[0] >= _0_GatherData
				&& stateConfVector[0] <= _0_GatherData__region0_ParseStringForData);
		case _0_GatherData__region0_ReceiveUDPString : 
			return (sc_boolean) (stateConfVector[0] == _0_GatherData__region0_ReceiveUDPString
			);
		case _0_GatherData__region0_ParseStringForData : 
			return (sc_boolean) (stateConfVector[0] == _0_GatherData__region0_ParseStringForData
			);
		default: return false;
	}
}

LeonieBrain::SCI_UdpInterface* LeonieBrain::getSCI_UdpInterface() {
	return &ifaceUdpInterface;
}


sc_string LeonieBrain::SCI_UdpInterface::get_message() {
	return message;
}

void LeonieBrain::SCI_UdpInterface::set_message(sc_string value) {
	message = value;
}

void LeonieBrain::setSCI_UdpInterface_OCB(SCI_UdpInterface_OCB* operationCallback) {
	ifaceUdpInterface_OCB = operationCallback;
}
LeonieBrain::SCI_ACIface_stat* LeonieBrain::getSCI_ACIface_stat() {
	return &ifaceACIface_stat;
}


sc_string LeonieBrain::SCI_ACIface_stat::get_faceID() {
	return faceID;
}

void LeonieBrain::SCI_ACIface_stat::set_faceID(sc_string value) {
	faceID = value;
}

sc_integer LeonieBrain::SCI_ACIface_stat::get_confidence() {
	return confidence;
}

void LeonieBrain::SCI_ACIface_stat::set_confidence(sc_integer value) {
	confidence = value;
}

sc_integer LeonieBrain::SCI_ACIface_stat::get_age() {
	return age;
}

void LeonieBrain::SCI_ACIface_stat::set_age(sc_integer value) {
	age = value;
}

sc_boolean LeonieBrain::SCI_ACIface_stat::get_gender() {
	return gender;
}

void LeonieBrain::SCI_ACIface_stat::set_gender(sc_boolean value) {
	gender = value;
}

sc_integer LeonieBrain::SCI_ACIface_stat::get_ethnicty() {
	return ethnicty;
}

void LeonieBrain::SCI_ACIface_stat::set_ethnicty(sc_integer value) {
	ethnicty = value;
}

sc_boolean LeonieBrain::SCI_ACIface_stat::get_glasses() {
	return glasses;
}

void LeonieBrain::SCI_ACIface_stat::set_glasses(sc_boolean value) {
	glasses = value;
}

sc_integer LeonieBrain::SCI_ACIface_stat::get_attractiveness() {
	return attractiveness;
}

void LeonieBrain::SCI_ACIface_stat::set_attractiveness(sc_integer value) {
	attractiveness = value;
}

LeonieBrain::SCI_ACIface_dyn* LeonieBrain::getSCI_ACIface_dyn() {
	return &ifaceACIface_dyn;
}


sc_integer LeonieBrain::SCI_ACIface_dyn::get_headGestures() {
	return headGestures;
}

void LeonieBrain::SCI_ACIface_dyn::set_headGestures(sc_integer value) {
	headGestures = value;
}

sc_boolean LeonieBrain::SCI_ACIface_dyn::get_speaking() {
	return speaking;
}

void LeonieBrain::SCI_ACIface_dyn::set_speaking(sc_boolean value) {
	speaking = value;
}

sc_string LeonieBrain::SCI_ACIface_dyn::get_emotions() {
	return emotions;
}

void LeonieBrain::SCI_ACIface_dyn::set_emotions(sc_string value) {
	emotions = value;
}

sc_integer LeonieBrain::SCI_ACIface_dyn::get_distance() {
	return distance;
}

void LeonieBrain::SCI_ACIface_dyn::set_distance(sc_integer value) {
	distance = value;
}

LeonieBrain::SCI_Aci* LeonieBrain::getSCI_Aci() {
	return &ifaceAci;
}


sc_integer LeonieBrain::SCI_Aci::get_countFoundFaces() {
	return countFoundFaces;
}

void LeonieBrain::SCI_Aci::set_countFoundFaces(sc_integer value) {
	countFoundFaces = value;
}

LeonieBrain::SCI_Kinect* LeonieBrain::getSCI_Kinect() {
	return &ifaceKinect;
}


sc_string LeonieBrain::SCI_Kinect::get_geste() {
	return geste;
}

void LeonieBrain::SCI_Kinect::set_geste(sc_string value) {
	geste = value;
}

LeonieBrain::SCI_LeapMotion* LeonieBrain::getSCI_LeapMotion() {
	return &ifaceLeapMotion;
}


sc_string LeonieBrain::SCI_LeapMotion::get_geste() {
	return geste;
}

void LeonieBrain::SCI_LeapMotion::set_geste(sc_string value) {
	geste = value;
}

LeonieBrain::SCI_ScitosRemoteControl* LeonieBrain::getSCI_ScitosRemoteControl() {
	return &ifaceScitosRemoteControl;
}


sc_boolean LeonieBrain::SCI_ScitosRemoteControl::get_emergencyStop() {
	return emergencyStop;
}

void LeonieBrain::SCI_ScitosRemoteControl::set_emergencyStop(sc_boolean value) {
	emergencyStop = value;
}

LeonieBrain::SCI_OpenDail* LeonieBrain::getSCI_OpenDail() {
	return &ifaceOpenDail;
}


sc_string LeonieBrain::SCI_OpenDail::get_speakerMsg() {
	return speakerMsg;
}

void LeonieBrain::SCI_OpenDail::set_speakerMsg(sc_string value) {
	speakerMsg = value;
}

sc_string LeonieBrain::SCI_OpenDail::get_leonieMsg() {
	return leonieMsg;
}

void LeonieBrain::SCI_OpenDail::set_leonieMsg(sc_string value) {
	leonieMsg = value;
}

LeonieBrain::SCI_Mira* LeonieBrain::getSCI_Mira() {
	return &ifaceMira;
}


sc_boolean LeonieBrain::SCI_Mira::get_randMove() {
	return randMove;
}

void LeonieBrain::SCI_Mira::set_randMove(sc_boolean value) {
	randMove = value;
}

LeonieBrain::SCI_FaceAnimation* LeonieBrain::getSCI_FaceAnimation() {
	return &ifaceFaceAnimation;
}


sc_string LeonieBrain::SCI_FaceAnimation::get_emotion() {
	return emotion;
}

void LeonieBrain::SCI_FaceAnimation::set_emotion(sc_string value) {
	emotion = value;
}


void LeonieBrain::InternalSCI::raise_start() {
	start_raised = true;
}

sc_boolean LeonieBrain::InternalSCI::isRaised_start() {
	return start_raised;
}

void LeonieBrain::InternalSCI::raise_faceFound() {
	faceFound_raised = true;
}

sc_boolean LeonieBrain::InternalSCI::isRaised_faceFound() {
	return faceFound_raised;
}

void LeonieBrain::InternalSCI::raise_noiseDetected() {
	noiseDetected_raised = true;
}

sc_boolean LeonieBrain::InternalSCI::isRaised_noiseDetected() {
	return noiseDetected_raised;
}

void LeonieBrain::InternalSCI::raise_textMsg() {
	textMsg_raised = true;
}

sc_boolean LeonieBrain::InternalSCI::isRaised_textMsg() {
	return textMsg_raised;
}

void LeonieBrain::InternalSCI::raise_onTriggerDataGatherer() {
	onTriggerDataGatherer_raised = true;
}

sc_boolean LeonieBrain::InternalSCI::isRaised_onTriggerDataGatherer() {
	return onTriggerDataGatherer_raised;
}

sc_integer LeonieBrain::InternalSCI::get_t() {
	return t;
}

void LeonieBrain::InternalSCI::set_t(sc_integer value) {
	t = value;
}


// implementations of all internal functions

sc_boolean LeonieBrain::check__0_Init_tr0_tr0() {
	return ifaceInternalSCI.start_raised;
}

sc_boolean LeonieBrain::check__0_FaceDataInterpretation_tr0_tr0() {
	return true;
}

sc_boolean LeonieBrain::check__0_TurnToNoise_tr0_tr0() {
	return ifaceInternalSCI.faceFound_raised;
}

sc_boolean LeonieBrain::check__0_MoveToPerson_tr0_tr0() {
	return ifaceACIface_dyn.distance < 10;
}

sc_boolean LeonieBrain::check__0_SearchForChar__region0_Standing_tr0_tr0() {
	return timeEvents[0];
}

sc_boolean LeonieBrain::check__0_SearchForChar__region0_Standing_tr1_tr1() {
	return ifaceInternalSCI.noiseDetected_raised;
}

sc_boolean LeonieBrain::check__0_SearchForChar__region0_Standing_tr2_tr2() {
	return ifaceInternalSCI.onTriggerDataGatherer_raised;
}

sc_boolean LeonieBrain::check__0_SearchForChar__region0_Standing_tr3_tr3() {
	return ifaceInternalSCI.faceFound_raised;
}

sc_boolean LeonieBrain::check__0_SearchForChar__region0_Walking_tr0_tr0() {
	return timeEvents[1];
}

sc_boolean LeonieBrain::check__0_SearchForChar__region0_Walking_tr1_tr1() {
	return ifaceInternalSCI.noiseDetected_raised;
}

sc_boolean LeonieBrain::check__0_SearchForChar__region0_Walking_tr2_tr2() {
	return ifaceInternalSCI.onTriggerDataGatherer_raised;
}

sc_boolean LeonieBrain::check__0_SearchForChar__region0_Walking_tr3_tr3() {
	return ifaceInternalSCI.faceFound_raised;
}

sc_boolean LeonieBrain::check__0_GatherData__region0_ReceiveUDPString_tr0_tr0() {
	return true;
}

sc_boolean LeonieBrain::check__0_GatherData__region0_ParseStringForData_tr0_tr0() {
	return true;
}

sc_boolean LeonieBrain::check__0_FaceDataInterpretation__region0__choice_0_tr0_tr0() {
	return ifaceACIface_stat.confidence < 90;
}

sc_boolean LeonieBrain::check__0_FaceDataInterpretation__region0__choice_0_tr1_tr1() {
	return ifaceACIface_stat.confidence >= 90;
}

void LeonieBrain::effect__0_Init_tr0() {
	exseq__0_Init();
	enseq__0_SearchForChar__region0_Standing_default();
}

void LeonieBrain::effect__0_FaceDataInterpretation_tr0() {
	exseq__0_FaceDataInterpretation();
	enseq__0_Idle_default();
}

void LeonieBrain::effect__0_TurnToNoise_tr0() {
	exseq__0_TurnToNoise();
	enseq__0_MoveToPerson_default();
}

void LeonieBrain::effect__0_MoveToPerson_tr0() {
	exseq__0_MoveToPerson();
	react__0_FaceDataInterpretation__region0__choice_0();
}

void LeonieBrain::effect__0_SearchForChar__region0_Standing_tr0() {
	exseq__0_SearchForChar__region0_Standing();
	enseq__0_SearchForChar__region0_Walking_default();
}

void LeonieBrain::effect__0_SearchForChar__region0_Standing_tr1() {
	exseq__0_SearchForChar();
	enseq__0_TurnToNoise_default();
}

void LeonieBrain::effect__0_SearchForChar__region0_Standing_tr2() {
	exseq__0_SearchForChar();
	enseq__0_GatherData__region0_ReceiveUDPString_default();
}

void LeonieBrain::effect__0_SearchForChar__region0_Standing_tr3() {
	exseq__0_SearchForChar();
	enseq__0_MoveToPerson_default();
}

void LeonieBrain::effect__0_SearchForChar__region0_Walking_tr0() {
	exseq__0_SearchForChar__region0_Walking();
	enseq__0_SearchForChar__region0_Standing_default();
}

void LeonieBrain::effect__0_SearchForChar__region0_Walking_tr1() {
	exseq__0_SearchForChar();
	enseq__0_TurnToNoise_default();
}

void LeonieBrain::effect__0_SearchForChar__region0_Walking_tr2() {
	exseq__0_SearchForChar();
	enseq__0_GatherData__region0_ReceiveUDPString_default();
}

void LeonieBrain::effect__0_SearchForChar__region0_Walking_tr3() {
	exseq__0_SearchForChar();
	enseq__0_MoveToPerson_default();
}

void LeonieBrain::effect__0_GatherData__region0_ReceiveUDPString_tr0() {
	exseq__0_GatherData__region0_ReceiveUDPString();
	enseq__0_GatherData__region0_ParseStringForData_default();
}

void LeonieBrain::effect__0_GatherData__region0_ParseStringForData_tr0() {
	exseq__0_GatherData__region0_ParseStringForData();
	enseq__0_GatherData__region0_ReceiveUDPString_default();
}

void LeonieBrain::effect__0_FaceDataInterpretation__region0__choice_0_tr0() {
	enseq__0_FaceDataInterpretation__region0_PersonUnknown_default();
}

void LeonieBrain::effect__0_FaceDataInterpretation__region0__choice_0_tr1() {
	enseq__0_FaceDataInterpretation__region0_PersonKnown_default();
}

/* Entry action for state 'Standing'. */
void LeonieBrain::enact__0_SearchForChar__region0_Standing() {
	/* Entry action for state 'Standing'. */
	timer->setTimer(this, &timeEvents[0], 10 * 1000, false);
	ifaceMira.randMove = false;
}

/* Entry action for state 'Walking'. */
void LeonieBrain::enact__0_SearchForChar__region0_Walking() {
	/* Entry action for state 'Walking'. */
	timer->setTimer(this, &timeEvents[1], 20 * 1000, false);
	ifaceMira.randMove = true;
}

/* Entry action for state 'ReceiveUDPString'. */
void LeonieBrain::enact__0_GatherData__region0_ReceiveUDPString() {
	/* Entry action for state 'ReceiveUDPString'. */
	ifaceUdpInterface_OCB->receive();
}

/* Entry action for state 'ParseStringForData'. */
void LeonieBrain::enact__0_GatherData__region0_ParseStringForData() {
	/* Entry action for state 'ParseStringForData'. */
	ifaceUdpInterface_OCB->parseString();
}

/* Exit action for state 'Standing'. */
void LeonieBrain::exact__0_SearchForChar__region0_Standing() {
	/* Exit action for state 'Standing'. */
	timer->unsetTimer(this, &timeEvents[0]);
}

/* Exit action for state 'Walking'. */
void LeonieBrain::exact__0_SearchForChar__region0_Walking() {
	/* Exit action for state 'Walking'. */
	timer->unsetTimer(this, &timeEvents[1]);
}

/* 'default' enter sequence for state Init */
void LeonieBrain::enseq__0_Init_default() {
	/* 'default' enter sequence for state Init */
	stateConfVector[0] = _0_Init;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state PersonKnown */
void LeonieBrain::enseq__0_FaceDataInterpretation__region0_PersonKnown_default() {
	/* 'default' enter sequence for state PersonKnown */
	stateConfVector[0] = _0_FaceDataInterpretation__region0_PersonKnown;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state PersonUnknown */
void LeonieBrain::enseq__0_FaceDataInterpretation__region0_PersonUnknown_default() {
	/* 'default' enter sequence for state PersonUnknown */
	stateConfVector[0] = _0_FaceDataInterpretation__region0_PersonUnknown;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state TurnToNoise */
void LeonieBrain::enseq__0_TurnToNoise_default() {
	/* 'default' enter sequence for state TurnToNoise */
	stateConfVector[0] = _0_TurnToNoise;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Idle */
void LeonieBrain::enseq__0_Idle_default() {
	/* 'default' enter sequence for state Idle */
	stateConfVector[0] = _0_Idle;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state MoveToPerson */
void LeonieBrain::enseq__0_MoveToPerson_default() {
	/* 'default' enter sequence for state MoveToPerson */
	stateConfVector[0] = _0_MoveToPerson;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Standing */
void LeonieBrain::enseq__0_SearchForChar__region0_Standing_default() {
	/* 'default' enter sequence for state Standing */
	enact__0_SearchForChar__region0_Standing();
	stateConfVector[0] = _0_SearchForChar__region0_Standing;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Walking */
void LeonieBrain::enseq__0_SearchForChar__region0_Walking_default() {
	/* 'default' enter sequence for state Walking */
	enact__0_SearchForChar__region0_Walking();
	stateConfVector[0] = _0_SearchForChar__region0_Walking;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state ReceiveUDPString */
void LeonieBrain::enseq__0_GatherData__region0_ReceiveUDPString_default() {
	/* 'default' enter sequence for state ReceiveUDPString */
	enact__0_GatherData__region0_ReceiveUDPString();
	stateConfVector[0] = _0_GatherData__region0_ReceiveUDPString;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state ParseStringForData */
void LeonieBrain::enseq__0_GatherData__region0_ParseStringForData_default() {
	/* 'default' enter sequence for state ParseStringForData */
	enact__0_GatherData__region0_ParseStringForData();
	stateConfVector[0] = _0_GatherData__region0_ParseStringForData;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region 0 */
void LeonieBrain::enseq__0_default() {
	/* 'default' enter sequence for region 0 */
	react__0__entry_Default();
}

/* Default exit sequence for state Init */
void LeonieBrain::exseq__0_Init() {
	/* Default exit sequence for state Init */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state FaceDataInterpretation */
void LeonieBrain::exseq__0_FaceDataInterpretation() {
	/* Default exit sequence for state FaceDataInterpretation */
	exseq__0_FaceDataInterpretation__region0();
}

/* Default exit sequence for state PersonKnown */
void LeonieBrain::exseq__0_FaceDataInterpretation__region0_PersonKnown() {
	/* Default exit sequence for state PersonKnown */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state PersonUnknown */
void LeonieBrain::exseq__0_FaceDataInterpretation__region0_PersonUnknown() {
	/* Default exit sequence for state PersonUnknown */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state TurnToNoise */
void LeonieBrain::exseq__0_TurnToNoise() {
	/* Default exit sequence for state TurnToNoise */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Idle */
void LeonieBrain::exseq__0_Idle() {
	/* Default exit sequence for state Idle */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state MoveToPerson */
void LeonieBrain::exseq__0_MoveToPerson() {
	/* Default exit sequence for state MoveToPerson */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state SearchForChar */
void LeonieBrain::exseq__0_SearchForChar() {
	/* Default exit sequence for state SearchForChar */
	exseq__0_SearchForChar__region0();
}

/* Default exit sequence for state Standing */
void LeonieBrain::exseq__0_SearchForChar__region0_Standing() {
	/* Default exit sequence for state Standing */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
	exact__0_SearchForChar__region0_Standing();
}

/* Default exit sequence for state Walking */
void LeonieBrain::exseq__0_SearchForChar__region0_Walking() {
	/* Default exit sequence for state Walking */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
	exact__0_SearchForChar__region0_Walking();
}

/* Default exit sequence for state ReceiveUDPString */
void LeonieBrain::exseq__0_GatherData__region0_ReceiveUDPString() {
	/* Default exit sequence for state ReceiveUDPString */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state ParseStringForData */
void LeonieBrain::exseq__0_GatherData__region0_ParseStringForData() {
	/* Default exit sequence for state ParseStringForData */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region 0 */
void LeonieBrain::exseq__0() {
	/* Default exit sequence for region 0 */
	/* Handle exit of all possible states (of LeonieBrain._0) at position 0... */
	switch(stateConfVector[ 0 ]) {
		case _0_Init : {
			exseq__0_Init();
			break;
		}
		case _0_FaceDataInterpretation__region0_PersonKnown : {
			exseq__0_FaceDataInterpretation__region0_PersonKnown();
			break;
		}
		case _0_FaceDataInterpretation__region0_PersonUnknown : {
			exseq__0_FaceDataInterpretation__region0_PersonUnknown();
			break;
		}
		case _0_TurnToNoise : {
			exseq__0_TurnToNoise();
			break;
		}
		case _0_Idle : {
			exseq__0_Idle();
			break;
		}
		case _0_MoveToPerson : {
			exseq__0_MoveToPerson();
			break;
		}
		case _0_SearchForChar__region0_Standing : {
			exseq__0_SearchForChar__region0_Standing();
			break;
		}
		case _0_SearchForChar__region0_Walking : {
			exseq__0_SearchForChar__region0_Walking();
			break;
		}
		case _0_GatherData__region0_ReceiveUDPString : {
			exseq__0_GatherData__region0_ReceiveUDPString();
			break;
		}
		case _0_GatherData__region0_ParseStringForData : {
			exseq__0_GatherData__region0_ParseStringForData();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void LeonieBrain::exseq__0_FaceDataInterpretation__region0() {
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of LeonieBrain._0.FaceDataInterpretation._region0) at position 0... */
	switch(stateConfVector[ 0 ]) {
		case _0_FaceDataInterpretation__region0_PersonKnown : {
			exseq__0_FaceDataInterpretation__region0_PersonKnown();
			break;
		}
		case _0_FaceDataInterpretation__region0_PersonUnknown : {
			exseq__0_FaceDataInterpretation__region0_PersonUnknown();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void LeonieBrain::exseq__0_SearchForChar__region0() {
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of LeonieBrain._0.SearchForChar._region0) at position 0... */
	switch(stateConfVector[ 0 ]) {
		case _0_SearchForChar__region0_Standing : {
			exseq__0_SearchForChar__region0_Standing();
			break;
		}
		case _0_SearchForChar__region0_Walking : {
			exseq__0_SearchForChar__region0_Walking();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void LeonieBrain::exseq__0_GatherData__region0() {
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of LeonieBrain._0.GatherData._region0) at position 0... */
	switch(stateConfVector[ 0 ]) {
		case _0_GatherData__region0_ReceiveUDPString : {
			exseq__0_GatherData__region0_ReceiveUDPString();
			break;
		}
		case _0_GatherData__region0_ParseStringForData : {
			exseq__0_GatherData__region0_ParseStringForData();
			break;
		}
		default: break;
	}
}

/* The reactions of state Init. */
void LeonieBrain::react__0_Init() {
	/* The reactions of state Init. */
	if (check__0_Init_tr0_tr0()) { 
		effect__0_Init_tr0();
	} 
}

/* The reactions of state PersonKnown. */
void LeonieBrain::react__0_FaceDataInterpretation__region0_PersonKnown() {
	/* The reactions of state PersonKnown. */
	effect__0_FaceDataInterpretation_tr0();
}

/* The reactions of state PersonUnknown. */
void LeonieBrain::react__0_FaceDataInterpretation__region0_PersonUnknown() {
	/* The reactions of state PersonUnknown. */
	effect__0_FaceDataInterpretation_tr0();
}

/* The reactions of state TurnToNoise. */
void LeonieBrain::react__0_TurnToNoise() {
	/* The reactions of state TurnToNoise. */
	if (check__0_TurnToNoise_tr0_tr0()) { 
		effect__0_TurnToNoise_tr0();
	} 
}

/* The reactions of state Idle. */
void LeonieBrain::react__0_Idle() {
	/* The reactions of state Idle. */
}

/* The reactions of state MoveToPerson. */
void LeonieBrain::react__0_MoveToPerson() {
	/* The reactions of state MoveToPerson. */
	if (check__0_MoveToPerson_tr0_tr0()) { 
		effect__0_MoveToPerson_tr0();
	} 
}

/* The reactions of state Standing. */
void LeonieBrain::react__0_SearchForChar__region0_Standing() {
	/* The reactions of state Standing. */
	if (check__0_SearchForChar__region0_Standing_tr0_tr0()) { 
		effect__0_SearchForChar__region0_Standing_tr0();
	}  else {
		if (check__0_SearchForChar__region0_Standing_tr1_tr1()) { 
			effect__0_SearchForChar__region0_Standing_tr1();
		}  else {
			if (check__0_SearchForChar__region0_Standing_tr2_tr2()) { 
				effect__0_SearchForChar__region0_Standing_tr2();
			}  else {
				if (check__0_SearchForChar__region0_Standing_tr3_tr3()) { 
					effect__0_SearchForChar__region0_Standing_tr3();
				} 
			}
		}
	}
}

/* The reactions of state Walking. */
void LeonieBrain::react__0_SearchForChar__region0_Walking() {
	/* The reactions of state Walking. */
	if (check__0_SearchForChar__region0_Walking_tr0_tr0()) { 
		effect__0_SearchForChar__region0_Walking_tr0();
	}  else {
		if (check__0_SearchForChar__region0_Walking_tr1_tr1()) { 
			effect__0_SearchForChar__region0_Walking_tr1();
		}  else {
			if (check__0_SearchForChar__region0_Walking_tr2_tr2()) { 
				effect__0_SearchForChar__region0_Walking_tr2();
			}  else {
				if (check__0_SearchForChar__region0_Walking_tr3_tr3()) { 
					effect__0_SearchForChar__region0_Walking_tr3();
				} 
			}
		}
	}
}

/* The reactions of state ReceiveUDPString. */
void LeonieBrain::react__0_GatherData__region0_ReceiveUDPString() {
	/* The reactions of state ReceiveUDPString. */
	effect__0_GatherData__region0_ReceiveUDPString_tr0();
}

/* The reactions of state ParseStringForData. */
void LeonieBrain::react__0_GatherData__region0_ParseStringForData() {
	/* The reactions of state ParseStringForData. */
	effect__0_GatherData__region0_ParseStringForData_tr0();
}

/* The reactions of state null. */
void LeonieBrain::react__0_FaceDataInterpretation__region0__choice_0() {
	/* The reactions of state null. */
	if (check__0_FaceDataInterpretation__region0__choice_0_tr0_tr0()) { 
		effect__0_FaceDataInterpretation__region0__choice_0_tr0();
	}  else {
		if (check__0_FaceDataInterpretation__region0__choice_0_tr1_tr1()) { 
			effect__0_FaceDataInterpretation__region0__choice_0_tr1();
		} 
	}
}

/* Default react sequence for initial entry  */
void LeonieBrain::react__0__entry_Default() {
	/* Default react sequence for initial entry  */
	enseq__0_Init_default();
}


