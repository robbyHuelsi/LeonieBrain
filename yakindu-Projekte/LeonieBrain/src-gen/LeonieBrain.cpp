
#include "LeonieBrain.h"
#include <string.h>
/*! \file Implementation of the state machine 'LeonieBrain'
*/

LeonieBrain::LeonieBrain() {
	
	
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
	ifaceAciPerson.name = "";
	ifaceAciPerson.age = 0;
	ifaceAciPerson.gender = false;
	ifaceAciPerson.ethnicty = 0;
	ifaceAciPerson.glasses = false;
	ifaceAciPerson.attractiveness = 0;
	ifaceAciPerson.speaking = false;
	ifaceAciPerson.emotions = "";
	ifaceAci.onOff = false;
	ifaceAci.countFoundFaces = 0;
	ifaceMira.randMove = false;
	ifaceInternalSCI.t = 0;

}

void LeonieBrain::enter()
{
	/* Default enter sequence for statechart LeonieBrain */
	enseq_main_region_default();
}

void LeonieBrain::exit()
{
	/* Default exit sequence for statechart LeonieBrain */
	exseq_main_region();
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
		case main_region_Init : {
			react_main_region_Init();
			break;
		}
		case main_region_IdleStanding : {
			react_main_region_IdleStanding();
			break;
		}
		case main_region_IdleWalking : {
			react_main_region_IdleWalking();
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
	ifaceInternalSCI.textMsg_raised = false; 
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
		case main_region_Init : 
			return (sc_boolean) (stateConfVector[0] == main_region_Init
			);
		case main_region_IdleStanding : 
			return (sc_boolean) (stateConfVector[0] == main_region_IdleStanding
			);
		case main_region_IdleWalking : 
			return (sc_boolean) (stateConfVector[0] == main_region_IdleWalking
			);
		default: return false;
	}
}

LeonieBrain::SCI_AciPerson* LeonieBrain::getSCI_AciPerson() {
	return &ifaceAciPerson;
}


sc_string LeonieBrain::SCI_AciPerson::get_name() {
	return name;
}

void LeonieBrain::SCI_AciPerson::set_name(sc_string value) {
	name = value;
}

sc_integer LeonieBrain::SCI_AciPerson::get_age() {
	return age;
}

void LeonieBrain::SCI_AciPerson::set_age(sc_integer value) {
	age = value;
}

sc_boolean LeonieBrain::SCI_AciPerson::get_gender() {
	return gender;
}

void LeonieBrain::SCI_AciPerson::set_gender(sc_boolean value) {
	gender = value;
}

sc_integer LeonieBrain::SCI_AciPerson::get_ethnicty() {
	return ethnicty;
}

void LeonieBrain::SCI_AciPerson::set_ethnicty(sc_integer value) {
	ethnicty = value;
}

sc_boolean LeonieBrain::SCI_AciPerson::get_glasses() {
	return glasses;
}

void LeonieBrain::SCI_AciPerson::set_glasses(sc_boolean value) {
	glasses = value;
}

sc_integer LeonieBrain::SCI_AciPerson::get_attractiveness() {
	return attractiveness;
}

void LeonieBrain::SCI_AciPerson::set_attractiveness(sc_integer value) {
	attractiveness = value;
}

sc_boolean LeonieBrain::SCI_AciPerson::get_speaking() {
	return speaking;
}

void LeonieBrain::SCI_AciPerson::set_speaking(sc_boolean value) {
	speaking = value;
}

sc_string LeonieBrain::SCI_AciPerson::get_emotions() {
	return emotions;
}

void LeonieBrain::SCI_AciPerson::set_emotions(sc_string value) {
	emotions = value;
}

LeonieBrain::SCI_Aci* LeonieBrain::getSCI_Aci() {
	return &ifaceAci;
}


sc_boolean LeonieBrain::SCI_Aci::get_onOff() {
	return onOff;
}

void LeonieBrain::SCI_Aci::set_onOff(sc_boolean value) {
	onOff = value;
}

sc_integer LeonieBrain::SCI_Aci::get_countFoundFaces() {
	return countFoundFaces;
}

void LeonieBrain::SCI_Aci::set_countFoundFaces(sc_integer value) {
	countFoundFaces = value;
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

void LeonieBrain::InternalSCI::raise_textMsg() {
	textMsg_raised = true;
}

sc_boolean LeonieBrain::InternalSCI::isRaised_textMsg() {
	return textMsg_raised;
}

sc_integer LeonieBrain::InternalSCI::get_t() {
	return t;
}

void LeonieBrain::InternalSCI::set_t(sc_integer value) {
	t = value;
}


// implementations of all internal functions

sc_boolean LeonieBrain::check_main_region_Init_tr0_tr0() {
	return ifaceInternalSCI.start_raised;
}

sc_boolean LeonieBrain::check_main_region_IdleStanding_tr0_tr0() {
	return timeEvents[0];
}

sc_boolean LeonieBrain::check_main_region_IdleWalking_tr0_tr0() {
	return timeEvents[1];
}

void LeonieBrain::effect_main_region_Init_tr0() {
	exseq_main_region_Init();
	enseq_main_region_IdleStanding_default();
}

void LeonieBrain::effect_main_region_IdleStanding_tr0() {
	exseq_main_region_IdleStanding();
	enseq_main_region_IdleWalking_default();
}

void LeonieBrain::effect_main_region_IdleWalking_tr0() {
	exseq_main_region_IdleWalking();
	enseq_main_region_IdleStanding_default();
}

/* Entry action for state 'IdleStanding'. */
void LeonieBrain::enact_main_region_IdleStanding() {
	/* Entry action for state 'IdleStanding'. */
	timer->setTimer(this, &timeEvents[0], 10 * 1000, false);
	ifaceAci.onOff = true;
}

/* Entry action for state 'IdleWalking'. */
void LeonieBrain::enact_main_region_IdleWalking() {
	/* Entry action for state 'IdleWalking'. */
	timer->setTimer(this, &timeEvents[1], 20 * 1000, false);
	ifaceAci.onOff = false;
}

/* Exit action for state 'IdleStanding'. */
void LeonieBrain::exact_main_region_IdleStanding() {
	/* Exit action for state 'IdleStanding'. */
	timer->unsetTimer(this, &timeEvents[0]);
}

/* Exit action for state 'IdleWalking'. */
void LeonieBrain::exact_main_region_IdleWalking() {
	/* Exit action for state 'IdleWalking'. */
	timer->unsetTimer(this, &timeEvents[1]);
}

/* 'default' enter sequence for state Init */
void LeonieBrain::enseq_main_region_Init_default() {
	/* 'default' enter sequence for state Init */
	stateConfVector[0] = main_region_Init;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state IdleStanding */
void LeonieBrain::enseq_main_region_IdleStanding_default() {
	/* 'default' enter sequence for state IdleStanding */
	enact_main_region_IdleStanding();
	stateConfVector[0] = main_region_IdleStanding;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state IdleWalking */
void LeonieBrain::enseq_main_region_IdleWalking_default() {
	/* 'default' enter sequence for state IdleWalking */
	enact_main_region_IdleWalking();
	stateConfVector[0] = main_region_IdleWalking;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void LeonieBrain::enseq_main_region_default() {
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state Init */
void LeonieBrain::exseq_main_region_Init() {
	/* Default exit sequence for state Init */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state IdleStanding */
void LeonieBrain::exseq_main_region_IdleStanding() {
	/* Default exit sequence for state IdleStanding */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
	exact_main_region_IdleStanding();
}

/* Default exit sequence for state IdleWalking */
void LeonieBrain::exseq_main_region_IdleWalking() {
	/* Default exit sequence for state IdleWalking */
	stateConfVector[0] = LeonieBrain_last_state;
	stateConfVectorPosition = 0;
	exact_main_region_IdleWalking();
}

/* Default exit sequence for region main region */
void LeonieBrain::exseq_main_region() {
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of LeonieBrain.main_region) at position 0... */
	switch(stateConfVector[ 0 ]) {
		case main_region_Init : {
			exseq_main_region_Init();
			break;
		}
		case main_region_IdleStanding : {
			exseq_main_region_IdleStanding();
			break;
		}
		case main_region_IdleWalking : {
			exseq_main_region_IdleWalking();
			break;
		}
		default: break;
	}
}

/* The reactions of state Init. */
void LeonieBrain::react_main_region_Init() {
	/* The reactions of state Init. */
	if (check_main_region_Init_tr0_tr0()) { 
		effect_main_region_Init_tr0();
	} 
}

/* The reactions of state IdleStanding. */
void LeonieBrain::react_main_region_IdleStanding() {
	/* The reactions of state IdleStanding. */
	if (check_main_region_IdleStanding_tr0_tr0()) { 
		effect_main_region_IdleStanding_tr0();
	} 
}

/* The reactions of state IdleWalking. */
void LeonieBrain::react_main_region_IdleWalking() {
	/* The reactions of state IdleWalking. */
	if (check_main_region_IdleWalking_tr0_tr0()) { 
		effect_main_region_IdleWalking_tr0();
	} 
}

/* Default react sequence for initial entry  */
void LeonieBrain::react_main_region__entry_Default() {
	/* Default react sequence for initial entry  */
	enseq_main_region_Init_default();
}


