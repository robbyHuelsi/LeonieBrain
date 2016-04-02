
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
			_0_Init,
			_0_FaceDataInterpretation,
			_0_FaceDataInterpretation__region0_PersonKnown,
			_0_FaceDataInterpretation__region0_PersonUnknown,
			_0_TurnToNoise,
			_0_Idle,
			_0_MoveToPerson,
			_0_SearchForChar,
			_0_SearchForChar__region0_Standing,
			_0_SearchForChar__region0_Walking,
			_0_GatherData,
			_0_GatherData__region0_ReceiveUDPString,
			_0_GatherData__region0_ParseStringForData,
			LeonieBrain_last_state
		} LeonieBrainStates;
		
		//! Inner class for UdpInterface interface scope.
		class SCI_UdpInterface {
			
			public:
				/*! Gets the value of the variable 'message' that is defined in the interface scope 'UdpInterface'. */ 
				sc_string get_message();
				
				/*! Sets the value of the variable 'message' that is defined in the interface scope 'UdpInterface'. */ 
				void set_message(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string message;
		};
				
				//! Inner class for UdpInterface interface scope operation callbacks.
				class SCI_UdpInterface_OCB {
					public:
						virtual ~SCI_UdpInterface_OCB() = 0;
						
						virtual void receive() = 0;
						
						virtual void parseString() = 0;
				};
				
				/*! Set the working instance of the operation callback interface 'SCI_UdpInterface_OCB'. */
				void setSCI_UdpInterface_OCB(SCI_UdpInterface_OCB* operationCallback);
		
		/*! Returns an instance of the interface class 'SCI_UdpInterface'. */
		SCI_UdpInterface* getSCI_UdpInterface();
		
		//! Inner class for ACIface_stat interface scope.
		class SCI_ACIface_stat {
			
			public:
				/*! Gets the value of the variable 'faceID' that is defined in the interface scope 'ACIface_stat'. */ 
				sc_string get_faceID();
				
				/*! Sets the value of the variable 'faceID' that is defined in the interface scope 'ACIface_stat'. */ 
				void set_faceID(sc_string value);
				
				/*! Gets the value of the variable 'confidence' that is defined in the interface scope 'ACIface_stat'. */ 
				sc_integer get_confidence();
				
				/*! Sets the value of the variable 'confidence' that is defined in the interface scope 'ACIface_stat'. */ 
				void set_confidence(sc_integer value);
				
				/*! Gets the value of the variable 'age' that is defined in the interface scope 'ACIface_stat'. */ 
				sc_integer get_age();
				
				/*! Sets the value of the variable 'age' that is defined in the interface scope 'ACIface_stat'. */ 
				void set_age(sc_integer value);
				
				/*! Gets the value of the variable 'gender' that is defined in the interface scope 'ACIface_stat'. */ 
				sc_boolean get_gender();
				
				/*! Sets the value of the variable 'gender' that is defined in the interface scope 'ACIface_stat'. */ 
				void set_gender(sc_boolean value);
				
				/*! Gets the value of the variable 'ethnicty' that is defined in the interface scope 'ACIface_stat'. */ 
				sc_integer get_ethnicty();
				
				/*! Sets the value of the variable 'ethnicty' that is defined in the interface scope 'ACIface_stat'. */ 
				void set_ethnicty(sc_integer value);
				
				/*! Gets the value of the variable 'glasses' that is defined in the interface scope 'ACIface_stat'. */ 
				sc_boolean get_glasses();
				
				/*! Sets the value of the variable 'glasses' that is defined in the interface scope 'ACIface_stat'. */ 
				void set_glasses(sc_boolean value);
				
				/*! Gets the value of the variable 'attractiveness' that is defined in the interface scope 'ACIface_stat'. */ 
				sc_integer get_attractiveness();
				
				/*! Sets the value of the variable 'attractiveness' that is defined in the interface scope 'ACIface_stat'. */ 
				void set_attractiveness(sc_integer value);
				
				
			private:
				friend class LeonieBrain;
				sc_string faceID;
				sc_integer confidence;
				sc_integer age;
				sc_boolean gender;
				sc_integer ethnicty;
				sc_boolean glasses;
				sc_integer attractiveness;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_ACIface_stat'. */
		SCI_ACIface_stat* getSCI_ACIface_stat();
		
		//! Inner class for ACIface_dyn interface scope.
		class SCI_ACIface_dyn {
			
			public:
				/*! Gets the value of the variable 'headGestures' that is defined in the interface scope 'ACIface_dyn'. */ 
				sc_integer get_headGestures();
				
				/*! Sets the value of the variable 'headGestures' that is defined in the interface scope 'ACIface_dyn'. */ 
				void set_headGestures(sc_integer value);
				
				/*! Gets the value of the variable 'speaking' that is defined in the interface scope 'ACIface_dyn'. */ 
				sc_boolean get_speaking();
				
				/*! Sets the value of the variable 'speaking' that is defined in the interface scope 'ACIface_dyn'. */ 
				void set_speaking(sc_boolean value);
				
				/*! Gets the value of the variable 'emotions' that is defined in the interface scope 'ACIface_dyn'. */ 
				sc_string get_emotions();
				
				/*! Sets the value of the variable 'emotions' that is defined in the interface scope 'ACIface_dyn'. */ 
				void set_emotions(sc_string value);
				
				/*! Gets the value of the variable 'distance' that is defined in the interface scope 'ACIface_dyn'. */ 
				sc_integer get_distance();
				
				/*! Sets the value of the variable 'distance' that is defined in the interface scope 'ACIface_dyn'. */ 
				void set_distance(sc_integer value);
				
				
			private:
				friend class LeonieBrain;
				sc_integer headGestures;
				sc_boolean speaking;
				sc_string emotions;
				sc_integer distance;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_ACIface_dyn'. */
		SCI_ACIface_dyn* getSCI_ACIface_dyn();
		
		//! Inner class for Aci interface scope.
		class SCI_Aci {
			
			public:
				/*! Gets the value of the variable 'countFoundFaces' that is defined in the interface scope 'Aci'. */ 
				sc_integer get_countFoundFaces();
				
				/*! Sets the value of the variable 'countFoundFaces' that is defined in the interface scope 'Aci'. */ 
				void set_countFoundFaces(sc_integer value);
				
				
			private:
				friend class LeonieBrain;
				sc_integer countFoundFaces;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_Aci'. */
		SCI_Aci* getSCI_Aci();
		
		//! Inner class for Kinect interface scope.
		class SCI_Kinect {
			
			public:
				/*! Gets the value of the variable 'geste' that is defined in the interface scope 'Kinect'. */ 
				sc_string get_geste();
				
				/*! Sets the value of the variable 'geste' that is defined in the interface scope 'Kinect'. */ 
				void set_geste(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string geste;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_Kinect'. */
		SCI_Kinect* getSCI_Kinect();
		
		//! Inner class for LeapMotion interface scope.
		class SCI_LeapMotion {
			
			public:
				/*! Gets the value of the variable 'geste' that is defined in the interface scope 'LeapMotion'. */ 
				sc_string get_geste();
				
				/*! Sets the value of the variable 'geste' that is defined in the interface scope 'LeapMotion'. */ 
				void set_geste(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string geste;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_LeapMotion'. */
		SCI_LeapMotion* getSCI_LeapMotion();
		
		//! Inner class for ScitosRemoteControl interface scope.
		class SCI_ScitosRemoteControl {
			
			public:
				/*! Gets the value of the variable 'emergencyStop' that is defined in the interface scope 'ScitosRemoteControl'. */ 
				sc_boolean get_emergencyStop();
				
				/*! Sets the value of the variable 'emergencyStop' that is defined in the interface scope 'ScitosRemoteControl'. */ 
				void set_emergencyStop(sc_boolean value);
				
				
			private:
				friend class LeonieBrain;
				sc_boolean emergencyStop;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_ScitosRemoteControl'. */
		SCI_ScitosRemoteControl* getSCI_ScitosRemoteControl();
		
		//! Inner class for openDail interface scope.
		class SCI_OpenDail {
			
			public:
				/*! Gets the value of the variable 'speakerMsg' that is defined in the interface scope 'openDail'. */ 
				sc_string get_speakerMsg();
				
				/*! Sets the value of the variable 'speakerMsg' that is defined in the interface scope 'openDail'. */ 
				void set_speakerMsg(sc_string value);
				
				/*! Gets the value of the variable 'leonieMsg' that is defined in the interface scope 'openDail'. */ 
				sc_string get_leonieMsg();
				
				/*! Sets the value of the variable 'leonieMsg' that is defined in the interface scope 'openDail'. */ 
				void set_leonieMsg(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string speakerMsg;
				sc_string leonieMsg;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_OpenDail'. */
		SCI_OpenDail* getSCI_OpenDail();
		
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
		
		//! Inner class for FaceAnimation interface scope.
		class SCI_FaceAnimation {
			
			public:
				/*! Gets the value of the variable 'emotion' that is defined in the interface scope 'FaceAnimation'. */ 
				sc_string get_emotion();
				
				/*! Sets the value of the variable 'emotion' that is defined in the interface scope 'FaceAnimation'. */ 
				void set_emotion(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string emotion;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_FaceAnimation'. */
		SCI_FaceAnimation* getSCI_FaceAnimation();
		
		
		
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
				
				/*! Raises the in event 'noiseDetected' that is defined in the internal scope. */ 
				void raise_noiseDetected();
				
				/*! Checks if the out event 'noiseDetected' that is defined in the internal scope has been raised. */ 
				sc_boolean isRaised_noiseDetected();
				
				/*! Raises the in event 'textMsg' that is defined in the internal scope. */ 
				void raise_textMsg();
				
				/*! Checks if the out event 'textMsg' that is defined in the internal scope has been raised. */ 
				sc_boolean isRaised_textMsg();
				
				/*! Raises the in event 'onTriggerDataGatherer' that is defined in the internal scope. */ 
				void raise_onTriggerDataGatherer();
				
				/*! Checks if the out event 'onTriggerDataGatherer' that is defined in the internal scope has been raised. */ 
				sc_boolean isRaised_onTriggerDataGatherer();
				
				/*! Gets the value of the variable 't' that is defined in the internal scope. */ 
				sc_integer get_t();
				
				/*! Sets the value of the variable 't' that is defined in the internal scope. */ 
				void set_t(sc_integer value);
				
				
			private:
				friend class LeonieBrain;
				sc_boolean start_raised;
				sc_boolean faceFound_raised;
				sc_boolean noiseDetected_raised;
				sc_boolean textMsg_raised;
				sc_boolean onTriggerDataGatherer_raised;
				sc_integer t;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		TimerInterface* timer;
		sc_boolean timeEvents[2];
		
		LeonieBrainStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		SCI_UdpInterface ifaceUdpInterface;
		SCI_UdpInterface_OCB* ifaceUdpInterface_OCB;
		SCI_ACIface_stat ifaceACIface_stat;
		SCI_ACIface_dyn ifaceACIface_dyn;
		SCI_Aci ifaceAci;
		SCI_Kinect ifaceKinect;
		SCI_LeapMotion ifaceLeapMotion;
		SCI_ScitosRemoteControl ifaceScitosRemoteControl;
		SCI_OpenDail ifaceOpenDail;
		SCI_Mira ifaceMira;
		SCI_FaceAnimation ifaceFaceAnimation;
		InternalSCI ifaceInternalSCI;
		
		// prototypes of all internal functions
		
		sc_boolean check__0_Init_tr0_tr0();
		sc_boolean check__0_FaceDataInterpretation_tr0_tr0();
		sc_boolean check__0_TurnToNoise_tr0_tr0();
		sc_boolean check__0_MoveToPerson_tr0_tr0();
		sc_boolean check__0_SearchForChar__region0_Standing_tr0_tr0();
		sc_boolean check__0_SearchForChar__region0_Standing_tr1_tr1();
		sc_boolean check__0_SearchForChar__region0_Standing_tr2_tr2();
		sc_boolean check__0_SearchForChar__region0_Standing_tr3_tr3();
		sc_boolean check__0_SearchForChar__region0_Walking_tr0_tr0();
		sc_boolean check__0_SearchForChar__region0_Walking_tr1_tr1();
		sc_boolean check__0_SearchForChar__region0_Walking_tr2_tr2();
		sc_boolean check__0_SearchForChar__region0_Walking_tr3_tr3();
		sc_boolean check__0_GatherData__region0_ReceiveUDPString_tr0_tr0();
		sc_boolean check__0_GatherData__region0_ParseStringForData_tr0_tr0();
		sc_boolean check__0_FaceDataInterpretation__region0__choice_0_tr0_tr0();
		sc_boolean check__0_FaceDataInterpretation__region0__choice_0_tr1_tr1();
		void effect__0_Init_tr0();
		void effect__0_FaceDataInterpretation_tr0();
		void effect__0_TurnToNoise_tr0();
		void effect__0_MoveToPerson_tr0();
		void effect__0_SearchForChar__region0_Standing_tr0();
		void effect__0_SearchForChar__region0_Standing_tr1();
		void effect__0_SearchForChar__region0_Standing_tr2();
		void effect__0_SearchForChar__region0_Standing_tr3();
		void effect__0_SearchForChar__region0_Walking_tr0();
		void effect__0_SearchForChar__region0_Walking_tr1();
		void effect__0_SearchForChar__region0_Walking_tr2();
		void effect__0_SearchForChar__region0_Walking_tr3();
		void effect__0_GatherData__region0_ReceiveUDPString_tr0();
		void effect__0_GatherData__region0_ParseStringForData_tr0();
		void effect__0_FaceDataInterpretation__region0__choice_0_tr0();
		void effect__0_FaceDataInterpretation__region0__choice_0_tr1();
		void enact__0_SearchForChar__region0_Standing();
		void enact__0_SearchForChar__region0_Walking();
		void enact__0_GatherData__region0_ReceiveUDPString();
		void enact__0_GatherData__region0_ParseStringForData();
		void exact__0_SearchForChar__region0_Standing();
		void exact__0_SearchForChar__region0_Walking();
		void enseq__0_Init_default();
		void enseq__0_FaceDataInterpretation__region0_PersonKnown_default();
		void enseq__0_FaceDataInterpretation__region0_PersonUnknown_default();
		void enseq__0_TurnToNoise_default();
		void enseq__0_Idle_default();
		void enseq__0_MoveToPerson_default();
		void enseq__0_SearchForChar__region0_Standing_default();
		void enseq__0_SearchForChar__region0_Walking_default();
		void enseq__0_GatherData__region0_ReceiveUDPString_default();
		void enseq__0_GatherData__region0_ParseStringForData_default();
		void enseq__0_default();
		void exseq__0_Init();
		void exseq__0_FaceDataInterpretation();
		void exseq__0_FaceDataInterpretation__region0_PersonKnown();
		void exseq__0_FaceDataInterpretation__region0_PersonUnknown();
		void exseq__0_TurnToNoise();
		void exseq__0_Idle();
		void exseq__0_MoveToPerson();
		void exseq__0_SearchForChar();
		void exseq__0_SearchForChar__region0_Standing();
		void exseq__0_SearchForChar__region0_Walking();
		void exseq__0_GatherData__region0_ReceiveUDPString();
		void exseq__0_GatherData__region0_ParseStringForData();
		void exseq__0();
		void exseq__0_FaceDataInterpretation__region0();
		void exseq__0_SearchForChar__region0();
		void exseq__0_GatherData__region0();
		void react__0_Init();
		void react__0_FaceDataInterpretation__region0_PersonKnown();
		void react__0_FaceDataInterpretation__region0_PersonUnknown();
		void react__0_TurnToNoise();
		void react__0_Idle();
		void react__0_MoveToPerson();
		void react__0_SearchForChar__region0_Standing();
		void react__0_SearchForChar__region0_Walking();
		void react__0_GatherData__region0_ReceiveUDPString();
		void react__0_GatherData__region0_ParseStringForData();
		void react__0_FaceDataInterpretation__region0__choice_0();
		void react__0__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
inline LeonieBrain::SCI_UdpInterface_OCB::~SCI_UdpInterface_OCB() {}
#endif /* LEONIEBRAIN_H_ */
