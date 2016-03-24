
#ifndef LEONIEBRAIN_H_
#define LEONIEBRAIN_H_

#include "sc_types.h"
#include "StatemachineInterface.h"
#include "TimedStatemachineInterface.h"

/*! \file Header of the state machine 'LeonieBrain'.
*/

class LeonieBrain : public TimedStatemachineInterface, public StatemachineInterface {
	
	public:
		
		LeonieBrain();
		
		~LeonieBrain();
		
		/*! Enumeration of all states */ 
		typedef enum {
			main_region_Init,
			main_region_IdleStanding,
			main_region_IdleWalking,
			LeonieBrain_last_state
		} LeonieBrainStates;
		
		//! Inner class for AciPerson interface scope.
		class SCI_AciPerson {
			
			public:
				/*! Gets the value of the variable 'name' that is defined in the interface scope 'AciPerson'. */ 
				sc_string get_name();
				
				/*! Sets the value of the variable 'name' that is defined in the interface scope 'AciPerson'. */ 
				void set_name(sc_string value);
				
				/*! Gets the value of the variable 'age' that is defined in the interface scope 'AciPerson'. */ 
				sc_integer get_age();
				
				/*! Sets the value of the variable 'age' that is defined in the interface scope 'AciPerson'. */ 
				void set_age(sc_integer value);
				
				/*! Gets the value of the variable 'gender' that is defined in the interface scope 'AciPerson'. */ 
				sc_boolean get_gender();
				
				/*! Sets the value of the variable 'gender' that is defined in the interface scope 'AciPerson'. */ 
				void set_gender(sc_boolean value);
				
				/*! Gets the value of the variable 'ethnicty' that is defined in the interface scope 'AciPerson'. */ 
				sc_integer get_ethnicty();
				
				/*! Sets the value of the variable 'ethnicty' that is defined in the interface scope 'AciPerson'. */ 
				void set_ethnicty(sc_integer value);
				
				/*! Gets the value of the variable 'glasses' that is defined in the interface scope 'AciPerson'. */ 
				sc_boolean get_glasses();
				
				/*! Sets the value of the variable 'glasses' that is defined in the interface scope 'AciPerson'. */ 
				void set_glasses(sc_boolean value);
				
				/*! Gets the value of the variable 'attractiveness' that is defined in the interface scope 'AciPerson'. */ 
				sc_integer get_attractiveness();
				
				/*! Sets the value of the variable 'attractiveness' that is defined in the interface scope 'AciPerson'. */ 
				void set_attractiveness(sc_integer value);
				
				/*! Gets the value of the variable 'speaking' that is defined in the interface scope 'AciPerson'. */ 
				sc_boolean get_speaking();
				
				/*! Sets the value of the variable 'speaking' that is defined in the interface scope 'AciPerson'. */ 
				void set_speaking(sc_boolean value);
				
				/*! Gets the value of the variable 'emotions' that is defined in the interface scope 'AciPerson'. */ 
				sc_string get_emotions();
				
				/*! Sets the value of the variable 'emotions' that is defined in the interface scope 'AciPerson'. */ 
				void set_emotions(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string name;
				sc_integer age;
				sc_boolean gender;
				sc_integer ethnicty;
				sc_boolean glasses;
				sc_integer attractiveness;
				sc_boolean speaking;
				sc_string emotions;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_AciPerson'. */
		SCI_AciPerson* getSCI_AciPerson();
		
		//! Inner class for Aci interface scope.
		class SCI_Aci {
			
			public:
				/*! Gets the value of the variable 'onOff' that is defined in the interface scope 'Aci'. */ 
				sc_boolean get_onOff();
				
				/*! Sets the value of the variable 'onOff' that is defined in the interface scope 'Aci'. */ 
				void set_onOff(sc_boolean value);
				
				/*! Gets the value of the variable 'countFoundFaces' that is defined in the interface scope 'Aci'. */ 
				sc_integer get_countFoundFaces();
				
				/*! Sets the value of the variable 'countFoundFaces' that is defined in the interface scope 'Aci'. */ 
				void set_countFoundFaces(sc_integer value);
				
				
			private:
				friend class LeonieBrain;
				sc_boolean onOff;
				sc_integer countFoundFaces;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_Aci'. */
		SCI_Aci* getSCI_Aci();
		
		//! Inner class for Mira interface scope.
		class SCI_Mira {
			
			public:
				/*! Gets the value of the variable 'randMove' that is defined in the interface scope 'Mira'. */ 
				sc_boolean get_randMove();
				
				/*! Sets the value of the variable 'randMove' that is defined in the interface scope 'Mira'. */ 
				void set_randMove(sc_boolean value);
				
				
			private:
				friend class LeonieBrain;
				sc_boolean randMove;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_Mira'. */
		SCI_Mira* getSCI_Mira();
		
		
		
		void init();
		
		void enter();
		
		void exit();
		
		void runCycle();
		
		/*!
		* Checks if the statemachine is active (until 2.4.1 this method was used for states).
		* A statemachine is active if it was entered. It is inactive if it has not been entered at all or if it was exited.
		*/
		sc_boolean isActive();
		
		
		/*!
		* Checks if all active states are final. 
		* If there are no active states then the statemachine is considered as inactive and this method returns false.
		*/
		sc_boolean isFinal();
		
		void setTimer(TimerInterface* timer);
		
		TimerInterface* getTimer();
		
		void raiseTimeEvent(sc_eventid event);
		
		/*! Checks if the specified state is active (until 2.4.1 the used method for states was calles isActive()). */
		sc_boolean isStateActive(LeonieBrainStates state);
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI {
			
			public:
				/*! Raises the in event 'start' that is defined in the internal scope. */ 
				void raise_start();
				
				/*! Checks if the out event 'start' that is defined in the internal scope has been raised. */ 
				sc_boolean isRaised_start();
				
				/*! Raises the in event 'faceFound' that is defined in the internal scope. */ 
				void raise_faceFound();
				
				/*! Checks if the out event 'faceFound' that is defined in the internal scope has been raised. */ 
				sc_boolean isRaised_faceFound();
				
				/*! Raises the in event 'textMsg' that is defined in the internal scope. */ 
				void raise_textMsg();
				
				/*! Checks if the out event 'textMsg' that is defined in the internal scope has been raised. */ 
				sc_boolean isRaised_textMsg();
				
				/*! Gets the value of the variable 't' that is defined in the internal scope. */ 
				sc_integer get_t();
				
				/*! Sets the value of the variable 't' that is defined in the internal scope. */ 
				void set_t(sc_integer value);
				
				
			private:
				friend class LeonieBrain;
				sc_boolean start_raised;
				sc_boolean faceFound_raised;
				sc_boolean textMsg_raised;
				sc_integer t;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		TimerInterface* timer;
		sc_boolean timeEvents[2];
		
		LeonieBrainStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		SCI_AciPerson ifaceAciPerson;
		SCI_Aci ifaceAci;
		SCI_Mira ifaceMira;
		InternalSCI ifaceInternalSCI;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_Init_tr0_tr0();
		sc_boolean check_main_region_IdleStanding_tr0_tr0();
		sc_boolean check_main_region_IdleWalking_tr0_tr0();
		void effect_main_region_Init_tr0();
		void effect_main_region_IdleStanding_tr0();
		void effect_main_region_IdleWalking_tr0();
		void enact_main_region_IdleStanding();
		void enact_main_region_IdleWalking();
		void exact_main_region_IdleStanding();
		void exact_main_region_IdleWalking();
		void enseq_main_region_Init_default();
		void enseq_main_region_IdleStanding_default();
		void enseq_main_region_IdleWalking_default();
		void enseq_main_region_default();
		void exseq_main_region_Init();
		void exseq_main_region_IdleStanding();
		void exseq_main_region_IdleWalking();
		void exseq_main_region();
		void react_main_region_Init();
		void react_main_region_IdleStanding();
		void react_main_region_IdleWalking();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* LEONIEBRAIN_H_ */
